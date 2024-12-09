#!/bin/bash

function check_file() {
        local file=$1

        echo "Checking file [$(realpath -s $file)]"

        # Extract links from the Markdown file
        # Grep: Find every Markdown-link ([{DESC}]({LINK}) in $file
        # Sed: Pipe all Markdown-links (with wrappers and description) and reduce them to the url
        LINKS=$(grep -oE '\[.*?\]\((https?:\/\/[^\)]+)\)' $file | sed -E 's/.*\((https?:\/\/[^\)]+)\)/\1/')

        for link in $LINKS; do
                # Use curl to check the URL
                # --write-out: Format the output - here: get only the http code
                response=$(curl -o /dev/null --write-out "%{http_code}" --silent --head --max-time 10 "$link")
                if [[ "$response" -eq 200 ]]; then
                        echo "[OK] $link"
                else
                        echo "[FAIL:$response] $link"
                fi
        done
}

function main() {
        FILES=$(find "." -type f -name "*.md")
        for file in $FILES; do
                check_file "$file"
                echo ""
        done
}

main

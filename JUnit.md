# JUnit - Ein Testframework
## Was ist JUnit?
- Unittest Framework für Java
- Vergleichbar mit PyTest für Python
- Stellt Klassen und Methoden für Unittests bereit

- Ermöglicht einfaches und schnelles schreiben von Tests
- Viele tools zur Automatisierung und Analyse

# JUnit - Ein Beispielprojekt
- Klasse `MyPath`
	- `public static int fibonacci(int iterations)`
	- `public static int add(int num1, int num2)`
- Klasse soll getestet werden

# Wie teste ich besser nicht?
- Häufig wird mit `psvm` getestet
- Funktionenrückgaben werden geprintet
- Manueller Vergleich von werten

- Schlecht weil
	- Fehleranfällig
	- Langsam zu schreiben
	- Klasse wird zugemüllt
	- Unorganisiert

# Wie teste ich denn richtig?
- Besser ist ein Framework zu nutzen
	- JUnit
- Testklasse muss erstellt werden
- Ordnerstruktur anlegen
	- `main` und `test` Subverzeichnisse
- `test` spiegelt `main`
- Testklassen heißen `{Klassenname}Test`

# Der erste Unit-test
- Mit `void my_fibonacci_test()` soll `MyMath.fibonacci` getestet werden
- Name der Funktion ist egal
	- Sollte aber inhaltlich Sinn machen
- Dekorator `@Test` damit JUnit die Funktion erkennt
- Test gilt als bestanden wenn die Funktion ohne eine Exception zu raisen
- In funktion werden Werte verglichen
- Wenn falsch -> Exception

# Assertions
- Von JUnit gestellt Funktionen sollten genutzt werden
	- Lesbarerer Code
	- Fehler in Tests werden unwahrscheinlicher
	- Mehr Informationen beim versagen
	- Toolkit kann ganz ausgeschöpft werden

# Live Coding - `getGrade` testen
- Funktion erklären
	- Schulnote von A - F soll abhängig von Punkten vergeben werden
	- Special Case: `points < 0`
		- Exception
- IntelliJ öffnen
- DemoProjekt laden
- Code schreiben und erklären:
	- Auf lambda expression eingehen
```java
@Test  
void my_grading_test() {  
    assertEquals(MyMath.getGrade(70), 'C');  
    assertEquals(MyMath.getGrade(55), 'F');  
    assertEquals(MyMath.getGrade(10), 'F');  
    assertEquals(MyMath.getGrade(100), 'A');
    
    assertThrows(
	    IllegalArgumentException.class,
	    () -> {
		    MyMath.getGrade(-1);
		}
	);
}
```
- Anknüpfen: TDD prinzip wäre, erst Tests schreiben und dann `MyMath.getGrade`

# JUnit und IntelliJ in Kooperation
- IntelliJ macht debuggen einfach
	- Ausführliche Fehlerreports
	- Side-by-side vergleiche
	- Einfache UI Elemente
	- Widgets zum ausführen einzelner Tests
	- uvm.

# Coverage-report mit JUnit
- Knapp:
	- Bericht über den von tests abgedeckten Code
	- Wird automatisch generiert
	- Extrem hilfreich und ein indikator guter Tests und guten Codes

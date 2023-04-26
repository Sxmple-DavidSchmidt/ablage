# Was ist JUnit5?
...
# Wie benutze ich JUnit5?
Beispielprojekt: Eine eigene Mathe Klasse:

Als Beispiel für Unittesting in Java habe ich eine Klasse geschrieben welche für mich die Fibonacci Folge berechnen oder zwei Vektoren addieren kann. Der Code sieht so aus:

![[mymath_klasse.png]]

Häufig hängt man am ende der Klasse den typischen `public static void main [...]` an in welchem man unterschiedliche Tests macht. Das könnte für das Beispiel in etwa so aussehen.

![[mymath_klasse_psvmtesting.png]]



Um code per Testcases mit JUnit zu testen ist es convention für eine zu testende Klasse eine seperate testklasse zu machen.
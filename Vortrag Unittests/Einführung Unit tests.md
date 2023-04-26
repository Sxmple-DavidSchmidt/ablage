# Was sind Unit tests?
![[Unit-test#Was sind Unit tests]]

# JUnit als Test Framework
JUnit ist ein Framework für Java, das speziell für Unit-Tests entwickelt wurde. Es stellt eine Sammlung von Klassen und Methoden bereit, die Entwickler nutzen können, um ihre Java-Programme automatisiert zu testen.

JUnit ermöglicht es Entwicklern, Tests schnell und einfach zu schreiben, auszuführen und zu analysieren. Es bietet eine Reihe von Assertions (Behauptungen), die verwendet werden können, um zu überprüfen, ob das erwartete Ergebnis einer bestimmten Methode mit dem tatsächlichen Ergebnis übereinstimmt.

JUnit bietet auch die Möglichkeit, Testfälle zu gruppieren, auszuführen und Berichte zu generieren. Entwickler können mithilfe von JUnit auch Test-Driven-Development (TDD) praktizieren, bei dem Tests vor dem Schreiben der tatsächlichen Implementierung geschrieben werden.

## Wie schreibe ich Unit-Tests?
Um zu zeigen wie Unit-Tests geschrieben werden hier mal ein Beispielprojekt:

![[mymath_klasse 3.png]]

```Java
public class MyMath {
    public static int fibonacci(int iterations) {
        int current = 1;
        int last = 0;

        while(iterations > 0) {
            current += last;
            last = current - last;
            iterations--;
        }
        return last;
    }

    public static int add(int num1, int num2) {
	    return num1 + num2;
    }
}
```

Die Klasse `MyMath` soll für ein imaginäres Projekt Funktionen bereitstellen.

### Wie mache ich es besser nicht

Um zu gewährleisten, dass die Funktionen korrekt funktionieren würde man häufig am Ende der Klasse eine neue `main` Methode machen in welcher die Funktionalität getestet wird. Das könnte in etwa so aussehen:

![[mymath_klasse_psvmtesting 1.png]]

```java
public static void main(String[] args) {
	for(int i = 0; i < 25; i++) {
		System.out.println(fibonacci(i));
	}
}
```

Man lässt sich einige Werte der Funktion ausgeben und überprüft manuell ob die Ausgabe stimmt.

Abgesehen davon, dass man so seine Klasse mit eigentlich irrelevantem (und noch dazu bei vielen Tests schwer lesbarem) Code zumüllt führt diese herangehensweise außerdem häufig dazu dass man kleine Fehler übersieht oder relevante Edge-Cases nicht testet.

### Wie mache ich es richtig?

#### Dateistruktur

Besser ist es mit einem Test-Framework (hier: JUnit) zu arbeiten. Um die Klasse mit JUnit zu testen muss man eine Test-Klasse erstellen. Empfohlen ist, Quellcode in Verzeichnisse `main` und `test` zu trennen und im `test` Verzeichniss das `main` Verzeichniss mit Tests zu spiegeln. In etwa so:

![[folder_structure.png]]

So kann sehr übersichtlich getestet werden und Quellcode für Tests kann für die Produktion vom Quellcode für das Projekt selbst getrennt werden. 

#### Der erste Unit test

Um in der Klasse `MyMathTest` die Funktionalität von `MyMath` zu testen können muss vorerst eine Funktion geschrieben werden, welche JUnit als einen Unit-Test erkennt. Das kann erreicht werden, indem man der Funktion den decorator `@Test` gibt. Der Name der Funktion ist übrigens irrelevant. Sinnig ist aber, den Testfunktionen einen Namen zu geben welcher beschreibt was getestet wird um sich das Leben beim Debuggen einfacher zu machen. 

Der Test gilt als bestanden bzw. erfolgreich, wenn die Funktion durchläuft ohne eine Exception zu raisen. Ziel ist also, innerhalb der Funktion Werte zu vergleichen und eine Exception zu raisen sollte ein Wert nicht korrekt sein. Das könnte man beispielsweise so erreichen:

![[MyMathTest_0.png]]
```java
package test.util;  

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;  

class MyMathTest {  

    @Test  
    void my_fibonacci_test() {  
        if (MyMath.fibonacci(0) != 0) {  
            throw new RuntimeException("Oh no! A Mistake!");  
        }  
  
        if (MyMath.fibonacci(7) != 13) {  
            throw new RuntimeException("Oh no! A Mistake!");  
        }  
    }  
  
}
```

Um den Test auszuführen kann man in Intellij, der IDE meiner Wahl, einfach auf den Button links von der Funktion clicken. 

![[Pasted image 20230423164229.png]]

JUnit generiert generiert dabei Automatisch einen Report ob der Test erfolgreich war bzw lässt den Nutzer wissen wo eine Exception geraised wurde. Leider bekommt man aktuell noch nicht mehr Informationen über Exceptions als wenn man innerhalb einer normalen  `main` Funktion testen würde. Und genau hier helfen die von JUnit bereitgestellten `Assertions` Funktionen an. 

#### Bessere Unit tests schreiben

Um JUnit effektiv zu nutzen werden die von JUnit bereitgestellten Assertions benutzt. Sie übernehmen das werfen von Exceptions, geben dem Nutzer beim Report mehr Informationen und bieten viel Funktionalität in wenig Code. 

Ganz besonders häufig benutzte Assertions wären:

```java
assertEquals(int a, int b) // Funktionert auch mit Doubles, String, etc.
assertTrue(boolean condition)
assertFalse(boolean condition)
assertNotNull(Object o) 
assertNotEquals(int a, int b)
assertSame(Object expected, Object actual)
...
```

Theoretisch lassen sich alleine mit den Funktionen `assertTrue` bzw. `assertFalse` die anderen Assertion funktionen ableiten aber um mehr Informationen von JUnit zu bekommen lohnt es sich die best passende Funktion zu wählen.

In unserem Fall vergleichen wir zwei Zahlen. Die beste Wahl der Assertion Funktion wäre also `assertEquals(...)`.  Das sieht implementiert so aus.

![[MyMathTest_1.png]]

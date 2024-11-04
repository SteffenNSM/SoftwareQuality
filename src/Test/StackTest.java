package Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;


public class StackTest {
    private Stack stack;

    @Before
    public void setUp() {
        stack = new Stack(5);  // Stack mit Größe 5 für die Tests
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());  // Stack ist anfangs leer
        stack.push(1);
        assertFalse(stack.isEmpty()); // Nach Push sollte der Stack nicht leer sein
    }

    @Test
    public void testPush() {
        stack.push(10);
        Assert.assertEquals(1, stack.size());  // Nach dem Push sollte die Größe 1 sein

        stack.push(20);
        Assert.assertEquals(2, stack.size());  // Nach einem zweiten Push sollte die Größe 2 sein

        // Teste StackOverflowError, wenn der Stack voll ist
        stack.push(30);
        stack.push(40);
        stack.push(50); // Jetzt ist der Stack voll

        try {
            stack.push(60);  // Dieser Push sollte eine Ausnahme werfen
            fail("StackOverflowError erwartet");
        } catch (StackOverflowError e) {
            // Erwarteter Fehler, Test bestanden
        }

        // Teste IllegalArgumentException für negative Werte
        try {
            stack.push(-1);
            fail("IllegalArgumentException erwartet");
        } catch (IllegalArgumentException e) {
            // Erwarteter Fehler, Test bestanden
        }
    }

    @Test
    public void testPop() {
        Assert.assertEquals(-1, stack.pop());  // Leerer Stack sollte -1 zurückgeben

        stack.push(10);
        stack.push(20);

        Assert.assertEquals(20, stack.pop());  // LIFO-Prinzip: zuletzt hinzugefügt, zuerst entfernt
        Assert.assertEquals(10, stack.pop());  // Das verbleibende Element
        Assert.assertEquals(-1, stack.pop());  // Wieder leerer Stack
    }

    @Test
    public void testSize() {
        Assert.assertEquals(0, stack.size());  // Anfänglich leerer Stack

        stack.push(10);
        Assert.assertEquals(1, stack.size());  // Nach einem Push

        stack.push(20);
        Assert.assertEquals(2, stack.size());  // Nach zwei Push-Operationen

        stack.pop();
        Assert.assertEquals(1, stack.size());  // Nach einem Pop sollte die Größe wieder 1 sein

        stack.pop();
        Assert.assertEquals(0, stack.size());  // Nach einem weiteren Pop sollte der Stack leer sein
    }

    @Test
    public void testTop() {
        assertEquals(-1, stack.top());  // Leerer Stack sollte -1 zurückgeben

        stack.push(10);
        assertEquals(10, stack.top());  // Oberstes Element nach Push von 10

        stack.push(20);
        assertEquals(20, stack.top());  // Oberstes Element nach Push von 20

        stack.pop();
        assertEquals(10, stack.top());  // Nach Pop sollte das nächste Element oben sein
    }

}

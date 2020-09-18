package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }

    /*This test checks whether method countNumbers suitably throws an NullPointerException if
    the current string is null*/
    @Test (expected = NullPointerException.class)
    public void testCountNumbers2() {
        mycustomstring.setString(null);
        assertEquals(new NullPointerException(), mycustomstring.countNumbers());
    }

    /* This test checks whether method countNumbers returns the right answer if the string doesn't contains any number*/
    @Test
    public void testCountNumbers3() {
        mycustomstring.setString("It's Thursday");
        assertEquals(0, mycustomstring.countNumbers());
    }

    /* This test checks whether method countNumbers returns the right answer if the string only contains number*/
    @Test
    public void testCountNumbers4() {
        mycustomstring.setString("12345678");
        assertEquals(1, mycustomstring.countNumbers());
    }

    /* This test checks whether method countNumbers returns the right answer if the string is empty*/
    @Test
    public void testCountNumbers5() {
        mycustomstring.setString("");
        assertEquals(0, mycustomstring.countNumbers());
    }

    /* This test checks whether method countNumbers returns the right answer if 2 numbers separated by space*/
    @Test
    public void testCountNumbers6() {
        mycustomstring.setString("This is number 123 321");
        assertEquals(2, mycustomstring.countNumbers());
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("'bt t0 6snh r6rh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    /*This test checks whether method getEveryNthCharacterFromBeginningOrEnd suitably throws
    an IllegalAccessException if n is less than 0 */
    @Test (expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd3() {
        mycustomstring.setString("I like detective movies");
        assertEquals(new IllegalAccessException(), mycustomstring.getEveryNthCharacterFromBeginningOrEnd(-1, true));
    }

    /*This test checks whether method getEveryNthCharacterFromBeginningOrEnd suitably throws
    an NullPointerException if current string is null but n is > 0 */
    @Test (expected = NullPointerException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd4() {
        mycustomstring.setString(null);
        assertEquals(new NullPointerException(), mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    /*This test checks whether method getEveryNthCharacterFromBeginningOrEnd suitably throws
    an IllegalAccessException if n is equal to 0 */
    @Test (expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd5() {
        mycustomstring.setString("I like detective movies");
        assertEquals(new IllegalAccessException(), mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, true));
    }

    /* This test checks whether method getEveryNthCharacterFromBeginningOrEnd returns a correct answer */
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd6() {
        mycustomstring.setString("It's a nice day");
        assertEquals("tsanc a", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));
    }

    /* This test checks whether method getEveryNthCharacterFromBeginningOrEnd returns a correct answer */
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd7() {
        mycustomstring.setString("It's a nice day");
        assertEquals("tsanc a", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));
    }

    /* This test checks whether method getEveryNthCharacterFromBeginningOrEnd returns a correct answer when n
    equals to the string length, and start from the end */
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd8() {
        mycustomstring.setString("Aa");
        assertEquals("A", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));
    }

    /* This test checks whether method getEveryNthCharacterFromBeginningOrEnd returns a correct answer when n
    equals to the string length, and  start from the front */
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd9() {
        mycustomstring.setString("Aa");
        assertEquals("a", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));
    }

    /* This test checks whether method getEveryNthCharacterFromBeginningOrEnd returns the empty string when
    sting is empty and n is equal to 1 */
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd10() {
        mycustomstring.setString("");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, true));
    }

    /* This test checks whether method getEveryNthCharacterFromBeginningOrEnd returns the correct string when the
    answer is a space */
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd11() {
        mycustomstring.setString("Aa b");
        assertEquals(" ", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    /* This test checks whether method getEveryNthCharacterFromBeginningOrEnd returns the whole string when n is
    equal to 1 */
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd12() {
        mycustomstring.setString("1234567");
        assertEquals("1234567", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, true));
    }

    /* This test checks whether method getEveryNthCharacterFromBeginningOrEnd returns an empty string when n is greater
    than string length */
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd13() {
        mycustomstring.setString("hello");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(10, false));
    }

    /* This test checks whether method getEveryNthCharacterFromBeginningOrEnd returns an empty string when n is greater
    than string length */
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd14() {
        mycustomstring.setString("hello");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(20, true));
    }

    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    /* This test checks whether method testConvertDigitsToNamesInSubstring suitably throws an IllegalArgumentException
    if startPosition is large than endPosition */
    @Test (expected = IllegalArgumentException.class)
    public void testConvertDigitsToNamesInSubstring2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(23, 17);
        assertEquals(new IllegalArgumentException(), mycustomstring.getString());
    }

    /* This test checks whether method testConvertDigitsToNamesInSubstring suitably throws a MyIndexOutOfBoundsException
    if startPosition is less than 1 */
    @Test (expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring3() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(0, 5);
        assertEquals(new MyIndexOutOfBoundsException(), mycustomstring.getString());
    }

    /* This test checks whether method testConvertDigitsToNamesInSubstring suitably throws a MyIndexOutOfBoundsException
    if endPosition is large than the length of the string */
    @Test (expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring4() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(1, 100);
        assertEquals(new MyIndexOutOfBoundsException(), mycustomstring.getString());
    }

    /* This test checks whether method testConvertDigitsToNamesInSubstring suitably throws a NullPointerException
    if startPosition is less than endPosition but the string is null */
    @Test (expected = NullPointerException.class)
    public void testConvertDigitsToNamesInSubstring5() {
        mycustomstring.setString(null);
        mycustomstring.convertDigitsToNamesInSubstring(6, 12);
        assertEquals(new NullPointerException(), mycustomstring.getString());
    }

    /* This test checks whether method testConvertDigitsToNamesInSubstring returns a correct answer when startPosition
    is equal to endPosition */
    @Test
    public void testConvertDigitsToNamesInSubstring6() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(6, 6);
        assertEquals("I'd bThreett3r put s0me d161ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    /* This test checks whether method testConvertDigitsToNamesInSubstring returns a correct answer when endPosition
    equals to startPosition + 1 */
    @Test
    public void testConvertDigitsToNamesInSubstring7() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(23, 24);
        assertEquals("I'd b3tt3r put s0me d1SixOnets in this 5tr1n6, right?", mycustomstring.getString());
    }

    /* This test checks whether method testConvertDigitsToNamesInSubstring returns a correct answer */
    @Test
    public void testConvertDigitsToNamesInSubstring8() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(3, 18);
        assertEquals("I'd bThreettThreer put sZerome d161ts in this 5tr1n6, right?", mycustomstring.getString());
    }

}

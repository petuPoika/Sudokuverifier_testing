import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

//implement tests to test Sudokuverifier with boundary values.  Use templates from Task 1 to derive and document test cases.
	
// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
String c = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
String i = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
SudokuVerifier v = new SudokuVerifier();

	@Test
	public void testCorrectString() {
		int a = v.verify(c);
		assertEquals("correct string", a, 0);
	}

	@Test
	public void testIncorrectString() {
		int a = v.verify(i);
		assertEquals("incorrect string", a, -2);
		
	}
	
	@Test
	public void testNumberZero() {
		String zero = "017369825632158947958724316825437169791586432346912758289643571573291684164875293";
		int a = v.verify(zero);
		assertEquals("incorrect string", a, -1);
	}

	@Test
	public void testNumberTen() {
		String zero = "4173698256321589479587243168254371697915864323469127582896435715732916841648752910";
		int a = v.verify(zero);
		assertEquals("incorrect string", a, -1);
	}
	
	@Test
	public void testNumberIntegerMax() {
		String zero = "2147483647";
		int a = v.verify(zero);
		assertEquals("incorrect string", a, -1);
	}
	
	@Test
	public void testCharA() {
		String zero = "a17369825632158947958724316825437169791586432346912758289643571573291684164875293";
		int a = v.verify(zero);
		assertEquals("incorrect string", a, 1);
	}
	
	@Test
	public void testSpace() {
		String zero = " 17369825632158947958724316825437169791586432346912758289643571573291684164875293";
		int a = v.verify(zero);
		assertEquals("incorrect string", a, 1);
	}
	
	@Test
	public void testÄ() {
		String zero = "ä17369825632158947958724316825437169791586432346912758289643571573291684164875293";
		int a = v.verify(zero);
		assertEquals("incorrect string", a, 1);
	}
	
	@Test
	public void testFloatingAndDecimal() {
		String zero = "0.000117369825632158947958724316825437169791586432346912758289643571573291684164875293";
		int a = v.verify(zero);
		assertEquals("incorrect string", a, -1);
	}
	
	@Test
	public void testFloatingAndDecimalAndComma() {
		String zero = "0,000117369825632158947958724316825437169791586432346912758289643571573291684164875293";
		int a = v.verify(zero);
		assertEquals("incorrect string", a, -1);
	}
	
	/* 417369825/632158947/958724316/825437169/791586432/346912758/289643571/573291684/164875293 */
	@Test
	public void testSameNumberSubGrid() {
		String zero = "447369825632158947958724316825437169791586432346912758289643571573291684164875293";
		int a = v.verify(zero);
		assertEquals("incorrect string", a, -2);
	}
	
	/* 417369825/632158947/958724316/825437169/791586432/346912758/289643571/573291684/164875293 */
	@Test
	public void testSameNumberSameRow() {
		String zero = "617369825432158947958724316825437169791586432346912758289643571573291684164875293";
		int a = v.verify(zero);
		assertEquals("incorrect string", a, -3);
	}
	
	/* 417369825/632158947/958724316/825437169/791586432/346912758/289643571/573291684/164875293 */
	@Test
	public void testSameNumberSameColumn() {
		String zero = "471369852632158947958724316825437169791586432346912758289643571573291684164875293";
		int a = v.verify(zero);
		assertEquals("incorrect string", a, -4);
	}
	
	
}

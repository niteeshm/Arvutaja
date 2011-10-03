package ee.ioc.phon.android.unitconv;

import javax.measure.unit.Unit;

/**
 * <p>Converts a unit conversion expression (String) into a number
 * and returns it as a string. If an error occurs then returns the
 * error message.</p>
 * 
 * <p>The input string is expected to be something like: 1 2 m IN ft</p>
 * 
 * TODO: make this code not ugly
 */

public class Converter {

	private final double mNumber;
	private final String mIn;
	private final String mOut;

	public Converter(String str) {
		String[] splits = str.split(" IN ");
		String number = splits[0].replaceFirst("[^0-9\\. ].*", "").replaceAll("[^0-9\\.]", "");
		mNumber = Double.parseDouble(number);
		mIn = splits[0].replaceFirst("^[0-9\\. ]+", "").replaceAll("\\s+", "");
		mOut = splits[1].replaceAll("\\s+", "");
	}


	/**
	 * @return pretty-printed version of the expression that was given to the constructor
	 */
	public String getIn() {
		return mNumber + " " + mIn + " IN " + mOut;
	}


	/**
	 * @return evaluation of the expression that was given to the constructor
	 */
	public String getOut() {
		return "" + Unit.valueOf(mIn).getConverterTo(Unit.valueOf(mOut)).convert(mNumber);
	}
}
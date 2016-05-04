package es.uned.lsi.eped.pract2016.parser;



public class ParserFactory {
	public static OperationsParser getParser(String scenario) {
		if (scenario.equals("S")) {
			return new OperationsMeasurerDecorator(new ParserSSceario());
		} else if (scenario.equals("C")) {
			return new OperationsMeasurerDecorator(new ParserCScenarario());
		}
		return null;
	}
}

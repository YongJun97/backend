package Book;

public class ScienceFiction extends Book {

	@Override
	public int getLateFees(int days) {
		// TODO Auto-generated method stub

		days = 500;
		return 3 * days;
	}
}

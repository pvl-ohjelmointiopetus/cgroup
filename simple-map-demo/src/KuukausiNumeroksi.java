
public class KuukausiNumeroksi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO: Lue syöte.
		
		String syote = "10. helmikuuta 2011";
		String[] osat = syote.split(" "); // pilkotaan osiin
		String paiva = osat[0].substring(0, osat[0].length() - 1); // päivämäärästä piste pois lopusta
		String kuukausi = osat[1]; // TODO: Muuta kuukausi numeroksi Mapin avulla
		String vuosi = osat[2];
		
		System.out.println(vuosi + "-" + kuukausi + "-"+ paiva);

	}

}

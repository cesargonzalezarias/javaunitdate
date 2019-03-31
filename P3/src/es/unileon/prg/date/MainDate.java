package es.unileon.prg.date;

public class MainDate {

	public static void main(String[] args) {

		Date today;

		try {
			today = new Date(1,1,2019);
			System.out.println(today);
		} 
		
		catch (DateException e) {
			System.out.println(e.getMessage());
		}
		
		Date hoy,ayer;
		try{
			hoy = new Date(13,8,2023);
			ayer = new Date (13,5,2033);
			System.out.println(hoy.isSameDay(ayer));
		}
		catch(DateException e){
			System.out.println("Fecha incorrecta");
		}
		
		Date hoy1,ayer1;
		try{
			hoy1 = new Date(13,8,2023);
			ayer1 = new Date (13,5,2033);
			System.out.println(hoy1.isSameMonth(ayer1));
		}
		catch(DateException e){
			System.out.println("fecha incorrecta");
		}
		
		Date hoy2,ayer2;
		try{
			hoy2 = new Date(13,8,2023);
			ayer2 = new Date (13,5,2023);
			System.out.println(hoy2.isSameYear(ayer2));
		}
		catch(DateException e){
			System.out.println("fecha incorrecta");
		}
		
		Date estacion;
		try{
			estacion = new Date(11,12,2012);
			System.out.println(estacion.seasonMonth());
		}
		catch(DateException e){
			System.out.println(e.getMessage());
		}
		
		Date mes;
		try{
			mes = new Date(11,1,2012);
			System.out.println(mes.nameOfMonth());
			System.out.println(mes.monthsRemaining());
			System.out.println(mes.diasFinMes());
			System.out.println(mes.mesNumDias());
		}
		catch(DateException e){
			System.out.println(e.getMessage());
		}




	}

}





/*	public string toString(){	
		
	public static void main (String args[]){
		Date day,otra;
		day = new Date(6,3,2019);
		otra = new Date(6,3,2019);
		hoy.isSameYear(otra);
	}
	
	
	
	public static void main (string args[]){
		date = today;
		today = new Date (13,3,2019);
		System.out.println(today.isDayRight();
	}
}
*/


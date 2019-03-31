package es.unileon.prg.date;

public class Date {

	private int day;
	private int month;
	private int year;


	public Date() {
		day=1;
		month=1;
		year=2017;
	}
	public Date(int day, int month, int year) throws DateException{

		this.day = day;
		this.month = month;
		this.year = year;
		if(month<1||month>12) {
			throw new DateException("Mes inexistente");
		}
		if(day<0||daysOfMonth()<day) {
			throw new DateException("Dia inexistente");
		}
		if(year<0) {
			throw new DateException("Año inexistente");
		}

		/*else{
			throw new DateException("La siguiente fecha no es valida: " +day+ "-" +month+ "-"+year);

		}*/
	}

	public String toString(){
		StringBuffer salida = new StringBuffer();

		salida.append(this.day);
		salida.append("/"+this.month);
		salida.append("/"+this.year);
		return salida.toString();
	}	

	public int daysOfMonth(){
		int number = 0;
		switch (this.month){
		case 1://next
		case 3://next
		case 5://next
		case 7://next
		case 8://next
		case 10://next
		case 12:
			number = 31;
			break;
		case 2:
			number = 28;
			break;
		case 4://next
		case 6://next
		case 9://next
		case 11:
			number = 30;
			break;
		default: 
			number = 33333;
		}
		return number;
	}

	private boolean isDayRight(int day,int month){
		boolean right = true;
		switch(month){
		case 1://next
		case 3://next
		case 5://next
		case 7://next
		case 8://next
		case 10://next
		case 12:
			if((day>31)||(day<0)){
				right = false;
			}
			break;
		case 2:
			if((day>28)||(day<0)){
				right = false;
			}
			break;
		case 4://next
		case 6://next
		case 9://next
		case 11:
			if((day>30)||(day<0)){
				right = false;
			}
		default:
			right = false;
		}	
		return right;
	}

	public String getSeasonName(){
		String season = " ";
		switch (month){
		case 1://next
		case 2://next
		case 12:
			season = "Winter";
			break;
		case 3://next
		case 4://next
		case 5:
			season = "Spring";
			break;
		case 6://next
		case 7://next
		case 8:
			season = "Summer";
			break;
		case 9://next
		case 10://next
		case 11:
			season = "Autumn";
			break;
		}
		return season;
	}

	public String getMonthName(){
		return this.nameOfMonth(this.month);
	}

	private String nameOfMonth(int month){
		String mes = " ";
		switch (month){
		case 1 : 
			mes = "January";
			break;
		case 2 :
			mes = "February";
			break;
		case 3 : 
			mes = "March";
			break;
		case 4 :
			mes = "April";
			break;
		case 5 : 
			mes = "May";
			break;
		case 6 :
			mes = "June";
			break;
		case 7 : 
			mes = "July";
			break;
		case 8 : 
			mes = "August";
			break;
		case 9 :
			mes = "September";
			break;
		case 10:	
			mes = "October";
			break;
		case 11 : 
			mes = "November";
			break;
		case 12 :
			mes = "December";
			break;
		}
		return mes;
	}

	public void setDay(int day) throws DateException{
		this.day = day;
		if(day<0||daysOfMonth()<day) {
			throw new DateException("Dia inexistente");
		}	
	}
	public void setMonth(int month) throws DateException{
		this.month = month;
		if(month<1||month>12) {
			throw new DateException("Mes inexistente");
		}
	}
	public void setYear(int year) throws DateException{	
		this.year = year;
		if(year<0) {
			throw new DateException("Año inexistente");
		}
	}

	public Date (Date anotherDate){
		this.day = anotherDate.getDay();
		this.month = anotherDate.getMonth();
		this.year = anotherDate.getYear();
	}

	public int getDay(){
		return day;
	}

	public int getMonth(){
		return month;
	}

	public int getYear(){
		return year;
	}

	public boolean isSameYear(Date anotherDate){
		if(this.year==anotherDate.getYear()){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean isSameMonth(Date anotherDate){
		if(this.month==anotherDate.getMonth()){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean isSameDay(Date anotherDate){
		if(this.day==anotherDate.getDay()){
			return true;
		}
		else{
			return false;
		}
	}

	/* public boolean isSameYear(Date anotherDate){
		return this.year == anotherDate.getYear();
	}

	public boolean isSameMonth(Date anotherDate){
		return this.month == anotherDate.getMonth();
	}	

	public boolean isSameDay(Date anotherDate){
		return this.day == anotherDate.getDay();
	}
	 */
	public boolean isSame(Date anotherDate){
		if((isSameYear(anotherDate))&&(isSameMonth(anotherDate))&&(isSameDay(anotherDate))){
			return true;
		}
		else{
			return false;
		}
	}

	private int daysOfMonth(int m){
		int number = 0;
		switch (m){
		case 1://next
		case 3://next
		case 5://next
		case 7://next
		case 8://next
		case 10://next
		case 12:
			number = 31;
			break;
		case 2:
			number = 28;
			break;
		case 4://next
		case 6://next
		case 9://next
		case 11:
			number = 30;
		default: 
			number = 33333;
		}
		return number;
	}


	public String getMonthsLeft(){
		int mes = getMonth();
		StringBuffer salida = new StringBuffer();

		for (int i=mes+1;i<=12;i++){
			salida.append(nameOfMonth(i)+" ");
		}
		return salida.toString();
	}

	public String getDaysLeftOfMonth(){
		StringBuffer exit=new StringBuffer();
		int nDias=30;
		int i=day+1;
		if (month ==1||month==3||month==5||month==7||month==8||month==10||month==12){
			nDias=31;
		}
		else if (month==2){
			nDias=28;
		}
		while(i<=nDias){
			exit.append(i+"/"+month+"/"+year+" ");
			i++;
		}
		return exit.toString();
	}

	public String getMonthsSameDays(){
		StringBuffer exit=new StringBuffer();
		int i=1;
		while(i<13){
			if(daysOfMonth(i)==daysOfMonth(month)){
				exit.append(nameOfMonth(i)+" ");
			}
			i++;
		}
		return exit.toString();
	}
	
	public Date tomorrow() {
		
		int dia=day;
		int mes=month;
		int anio=year;
		dia++;
		System.out.println(dia);
		if(daysOfMonth(mes)<dia) {
			mes++;
			dia=1;
		}
		if(mes>12) {
			mes=1;
			anio++;
		}
		try {
			return new Date(dia, mes, anio);
		} catch (DateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}






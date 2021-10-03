package mod1;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Sample {
    private Date fecha;
    private String place;
    private String vName;
    private float perc;
    private int numb;
    private int sSize; // sample size

    public Sample() throws ParseException{
        setFecha("01/01/2000");
        setPlace("unknown");
        setvName("unknown");
        setPerc(0);
        setNumb(0);
        setsSize(0);
    }

    public Sample(String fe, String pl, String vN, int pe, int nu, int sS) throws ParseException{
        setFecha(fe);
        setPlace(pl);
        setvName(vN);
        setPerc(pe);
        setNumb(nu);
        setsSize(sS);
    }


    public Date getFecha(){ return fecha;}
    public String getPlace(){ return place;}
    public String getvName(){ return vName;}
    public float getPerc() {return perc;}
    public int getNumb() {return numb;} 
    public int getsSize() {return sSize;}

    //setters
    public void setFecha(String string) throws ParseException{
        SimpleDateFormat formating = new SimpleDateFormat("MM/dd/yyyy");
        Date fDate = formating.parse(string);
        this.fecha = fDate;
        
    }
    public void setPlace(String place){
        this.place = place;
    }
    public void setvName(String vName){
        this.vName = vName;
    }
    public void setPerc(float perc){
        this.perc = perc;
    }
    public void setNumb(int numb){
        this.numb = numb;
    }
    public void setsSize(int sSize){
        this.sSize = sSize;
    }
    
    public void display(){
        String line1 = "\n" + this.place + " --ON Date of: " + this.fecha; 
        String line2 = "\n" + this.vName;
        String line3 = "\nnumber: " + this.numb;
        String line4 = "\nPercent of sample: " + this.perc;
        String line5 = "\ntotal in sample: " + sSize;
        
        System.out.println(line1 + line2 + line3 + line4 + line5);

    }

    
}



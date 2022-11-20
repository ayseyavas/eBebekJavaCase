import java.util.ArrayList;

public class MobilePhone extends Product{
    private static int pId=1;
    private int battery;
    private String color;
    private int camResolution;
    private static ArrayList<MobilePhone> phones=new ArrayList<>();

    public MobilePhone(){

    }
    //Consturactor
    public MobilePhone(String name, double price, int discountRate, int amount,
                       Brand brand, double screenSize, int ram, int memory,
                       int battery, String color, int camResolution) {
        super(pId,name, price, discountRate, amount, brand, screenSize, ram, memory);
        pId++;
        this.battery=battery;
        this.color=color;
        this.camResolution=camResolution;
    }
    //Menu for Phone
    @Override
    public void menu() {
        System.out.println("1- Yeni Telefon ekle\n" +
                "2- Telefon listesini goruntule\n" +
                "3- Telefon sil\n" +
                "4- Telefonlari id numarasina gore sirala\n" +
                "5- Telefonlari markaya gore filtrele");
        System.out.print("Yapmak istediginiz islemi seciniz : ");
        int value=scanner.nextInt();
        if(value==1) addItem();
        if(value==2 || value==4) getProducts();
        if(value==3) deleteItem();
        if(value==5) brandFilter();
    }
    //Adding product for Phone
    @Override
    public void addItem() {
        System.out.print("Urunun fiyati : ");
        double price= scanner.nextDouble();
        System.out.print("Urunun adi : ");
        scanner.nextLine();
        String name=scanner.nextLine();
        System.out.print("Urunun indirim orani : ");
        int discountRate= scanner.nextInt();
        System.out.print("Urunun stogu : ");
        int amount= scanner.nextInt();
        System.out.print("Urunun rami : ");
        int ram= scanner.nextInt();
        System.out.print("Urunun ekrani : ");
        double screenSize= scanner.nextDouble();
        System.out.print("Urunun hafizasi :");
        int memory= scanner.nextInt();
        System.out.print("Urunun pili : ");
        int battery= scanner.nextInt();
        scanner.nextLine();
        System.out.print("Urunun rengi : ");
        String color= scanner.nextLine();
        System.out.print("Kamera çozunurlugu : ");
        int camResolution= scanner.nextInt();
        Brand.printBrands();
        System.out.print("Marka Seciniz : ");
        Brand brand=Brand.getBrand(scanner.nextInt());
        MobilePhone phone=new MobilePhone(name,price,discountRate,amount,brand,screenSize,ram,memory,battery,color,camResolution);
        phones.add(phone);
        System.out.println("Eklenen telefonun id'si :"+phone.getId());
    }

    public void getProducts() {
        print(null);
    }
    //Printing for Phone
    public void print(ArrayList<MobilePhone> phoneList){
        if(phoneList==null) phoneList=this.phones;
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Urun Adi                  | Fiyati          | Markasi         | Stogu        | İndirim Orani      | RAM    | Ekran Boyutu      | Hafizasi   | Pil Kapasitesi  | Renk           | Kamera    |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (MobilePhone n:phoneList){
            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | %-15s | %-14s | %-9s | \n",
                    n.getId(),n.getName(),n.getPrice(),n.getBrand().getName(),n.getAmount(),
                    n.getDiscountRate(),n.getRam(),n.getScreenSize(),n.getMemory(),n.getBattery(),n.getColor(),n.getCamResolution());
        }
    }
    //Deleting for Phone
    @Override
    public void deleteItem(){
        getProducts();
        System.out.print("Silinmesini istediginiz telefonun Id numarasini giriniz : ");
        int id=scanner.nextInt();
        phones.remove(id-1);
        System.out.println("Guncel telefon listesi ");
        getProducts();
    }
    //Filtering fot Phones by brand
    public void brandFilter(){
        scanner.nextLine();
        System.out.print("Filtrelemek istediginiz urun markasini giriniz :");
        String filter= scanner.nextLine();
        ArrayList<MobilePhone> filterPhones=new ArrayList<>();
        for (MobilePhone n:phones){
            if(filter.equals(n.getBrand().getName())){
                filterPhones.add(n);
            }
        }
        print(filterPhones);
    }
    //Getters and Setters
    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCamResolution() {
        return camResolution;
    }

    public void setCamResolution(int camResolution) {
        this.camResolution = camResolution;
    }

    public static int getpId() {
        return pId;
    }
}
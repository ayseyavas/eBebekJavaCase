import java.util.Scanner;

public class Store {
    Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("PatikaStore Urun Yonetim Paneli !");
            System.out.println(" 1 - Notebook Islemleri\n" +
                    " 2 - Cep Telefonu Islemleri\n" +
                    " 3 - Marka Listele\n" +
                    " 4 - Cikis Yap");
            System.out.print("Yapmak istediginiz islem numarasini seciniz : ");

            switch (scanner.nextInt()) {
                case 1:
                    // Notebook operations
                    Notebook notebook = new Notebook();
                    notebook.menu();
                    break;
                case 2:
                    // Phone operations
                    MobilePhone mobilePhone = new MobilePhone();
                    mobilePhone.menu();

                    break;
                case 3:
                    Brand.printBrands();
                    break;
                case 4:
                    // Exit system
                    System.out.println("Cikis yapiliyor.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Yanlis deger girdiniz.");
                    break;
            }
            scanner.close();
        }

    }

}
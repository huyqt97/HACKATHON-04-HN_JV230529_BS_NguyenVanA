package ra.bussiness;

import java.util.Scanner;

public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private String des;
    private double importPrice;
    private double exportPrice;
    private float interst;
    private boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String author, String des, double importPrice, double exportPrice, float interst, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.des = des;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interst = interst;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterst() {
        return interst;
    }

    public void setInterst(float interst) {
        this.interst = interst;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData(Book[] books, int autoId) {
        Scanner sc = new Scanner(System.in);
        int check = -1;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                check = i;
                break;
            }
        }
        if (check != -1) {
            int idNew = autoId;
            System.out.println("Nhập Tên sách :");
            String nameNew = sc.nextLine();
            System.out.println("Tác giả:");
            String authorNew = sc.nextLine();
            System.out.println("Mô tả:");
            String desNew = sc.nextLine();
            System.out.println("Giá nhập :");
            double importPriceNew = Double.parseDouble(sc.nextLine());
            double exportPriceNew = importPriceNew * 1.2;
            System.out.println("giá xuất : " + (exportPriceNew));
            float interestNew = Float.parseFloat(String.valueOf((exportPriceNew - importPriceNew)));
            System.out.println("Lợi nhuận : " + (interestNew));
            System.out.println("Trạng thái :");
            System.out.println("1. Còn hàng");
            System.out.println("2. Hết hàng");
            int choice1 = Integer.parseInt(sc.nextLine());
            boolean statusNew = false;
            switch (choice1) {
                case 1:
                    statusNew = true;
                    break;
                case 2:
                    break;
                default:
                    System.err.println("không hợp lệ mời nhập lại!");
            }
            books[check] = new Book(idNew, nameNew, authorNew, desNew, importPriceNew, exportPriceNew, interestNew, statusNew);
        }
    }

    public void displayData(Book book) {
        System.out.println("Book :" +
                "bookId=" + book.getBookId() +
                ", bookName='" + book.getBookName() + '\'' +
                ", author='" + book.getAuthor() + '\'' +
                ", des='" + book.getDes() + '\'' +
                ", importPrice=" + book.getImportPrice() +
                ", exportPrice=" + book.getExportPrice() +
                ", interst=" + book.getInterst() +
                ", bookStatus=" + ((book.isBookStatus()) ? "còn hàng" : "hết hàng"));
    }
}

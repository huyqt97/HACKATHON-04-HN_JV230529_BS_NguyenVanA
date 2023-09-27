package ra.run;

import ra.bussiness.Book;

import java.util.Scanner;

public class BookManagement {
    static Book book = new Book();
    static Scanner sc = new Scanner(System.in);
    static Book[] books = new Book[100];
    static {
        books[0] = new Book(1,"đắc nhân tâm", "Huy","cái gì đó",0,0,0,true);
    }

    public static void main(String[] args) {
        ControllerBook();
    }

    public static void ControllerBook() {
        System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************");
        System.out.println("1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách");
        System.out.println("2. Hiển thị thông tin tất cả sách trong thư viện");
        System.out.println("3. Sắp xếp sách theo lợi nhuận tăng dần");
        System.out.println("4. Xóa sách theo mã sách");
        System.out.println("5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả");
        System.out.println("6. Thay đổi thông tin sách theo mã sách");
        System.out.println("7. Thoát");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                CreateBook();
                break;
            case 2:
                DisplayBooks();
                break;
            case 3:
                sortInterest();
                break;
            case 4:
                deleteBook();
                break;
            case 5:
                search();
                break;
            case 6:
                updateBook();
                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.err.println("lựa chọn không hợp lệ!");
        }
    }

    public static void CreateBook() {
        System.out.println("Nhập số lượng sách muốn thêm : ");
        int quantity = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < quantity; i++) {
            System.out.println("Nhập thông tin cuốn sách " + (i + 1) + " : ");
            book.inputData(books, autoId());
        }
        ControllerBook();
    }

    public static void DisplayBooks() {
        System.out.println("************* Danh sách Book *************");
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                book.displayData(books[i]);
            }
        }
        ControllerBook();
    }

    public static void sortInterest() {
        int min = Integer.parseInt(String.valueOf(books[0].getInterst()));
        for (int i = 0; i < books.length; i++) {
            for (int j = i; j < books.length; j++) {
                if (books[i] != null && books[i].getInterst() < min) {

                }
            }

        }
    }
    public static void deleteBook(){
        System.out.println("Nhập ID sách muốn xóa :");
        int choice2 = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < books.length; i++) {
            if(books[i]!= null && books[i].getBookId() == choice2){
                books[choice2] = null;
                System.out.println("xóa thành công!");
                ControllerBook();
                break;
            }else {
                System.err.println("không tim thấy Id muốn xóa");
                deleteBook();
            }
        }
    }

    public static void search() {
        System.out.println("Nhập từ khóa muốn tìm :");
        String search = sc.nextLine();
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                for (int j = i; j < books.length; j++) {
                    if(books[i].getInterst()>books[j].getInterst()) {
                        Book box = books[i];
                        books[i] =books[j];
                        books[j]= box;
                    }
                }
            }
        }
        System.out.println("Danh sách được sắp xếp lại :");
        for (int i = 0; i < books.length; i++) {
            if(books[i] != null){
                book.displayData(books[i]);
            }
        }
        ControllerBook();
    }

    public static void updateBook() {
        System.out.println("Nhập ID sách muốn chỉnh sửa :");
        int choice = Integer.parseInt(sc.nextLine());
        int id = -1;
        for (int i = 0; i < books.length; i++) {
            if ( books[i]!=null && books[i].getBookId() == choice) {
                id = i;
            }
        }
        if (id != -1) {
            System.out.println("Nhập Tên sách :");
            books[id].setBookName(sc.nextLine());
            System.out.println("Tác giả:");
            books[id].setAuthor(sc.nextLine());
            System.out.println("Mô tả:");
            books[id].setDes(sc.nextLine());
            System.out.println("Giá nhập :");
            double importPriceNew = Double.parseDouble(sc.nextLine());
            books[id].setImportPrice(importPriceNew);
            double exportPriceNew = importPriceNew*1.2;
            books[id].setExportPrice(exportPriceNew);
            System.out.println("giá xuất : " + (exportPriceNew));
            float interestNew = Float.parseFloat(String.valueOf((exportPriceNew-importPriceNew)));
            books[id].setInterst(interestNew);
            System.out.println("Lợi nhuận : " + (interestNew));
            System.out.println("Trạng thái :");
            System.out.println("1. Còn hàng");
            System.out.println("2. Hết hàng");
            int choice1 = Integer.parseInt(sc.nextLine());
            switch (choice1){
                case 1:
                    books[id].setBookStatus(true);
                    break;
                case 2:
                    books[id].setBookStatus(false);
                    break;
                default:
                    System.err.println("không hợp lệ mời nhập lại!");
            }
            System.out.println("sửa thành công!");
            ControllerBook();
        }else {
            System.err.println("không tìm thấy sách muốn sửa!");
        updateBook();
        }
    }

    public static int autoId() {
        int max = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                if (books[i].getBookId() > max) {
                    max = book.getBookId();
                }
            }
        }
        return max + 1;
    }
}

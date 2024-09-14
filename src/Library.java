import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> booka;
    private final List<Member> members;

    public Library() {
        booka = new ArrayList<>();
        members = new ArrayList<>();
    }
    public void addBook(Book book) {
        booka.add(book);
    }
    public void registerMember(Member member) {
        members.add(member);
    }
    public void lendBook(String isbn, int memberId){
        Book book = findBookByIsbn(isbn);
        Member member = findMemberById(memberId);
        if (book != null && member != null) {
            member.borrowBook(book);
        } else{
            System.out.println("Invalid book ISBN or member ID");
        }
    }

    private Book findBookByIsbn(String isbn) {
        for (Book book : booka) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    private Member findMemberById(int memberId) {
        for (Member member : members) {
            if(Integer.parseInt(member.getMemberID()) == memberId){
                return member;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Library library = new Library();
        Book book1 = new Book("The Way To Court", "KezaIranga", "ISBN 9", 8000);
        Book book2 = new Book("The Power Of The Eyes", "Lora Pedro ", "ISBN 6", 10000);
        library.addBook(book1);
        library.addBook(book2);
        Member member1 = new Member("Jessy", 421);
        Member member2 = new Member("Tokyo", 231);
        library.registerMember(member1);
        library.registerMember(member2);

        library.lendBook("K09", 421);
        library.lendBook("Z11", 231);
    }

}

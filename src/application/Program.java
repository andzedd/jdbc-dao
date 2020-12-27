package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("========== TEST 1: sellerFindById ==========");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n========== TEST 2: sellerFindByDepartment ==========");
        Department dep = new Department(2, "Electronics");
        List<Seller> sellers = sellerDao.findByDepartment(dep);
        sellers.forEach(i -> System.out.println(i));

        System.out.println("\n========== TEST 3: sellerFindAll ==========");
        sellers = sellerDao.findAll();
        sellers.forEach(i -> System.out.println(i));

        System.out.println("\n========== TEST 4: sellerInsert ==========");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, dep);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New ID = " + newSeller.getId());

        System.out.println("\n========== TEST 5: sellerUpdate ==========");
        seller = sellerDao.findById(1);
        seller.setName("Martha Wayne");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println("\n========== TEST 6: sellerDelete ==========");
        System.out.print("Enter ID for deletion: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Seller deleted");
        sc.close();
    }
}

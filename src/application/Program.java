package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("========== TEST 1: sellerFindById ==========");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n========== TEST 2: sellerFindByDepartment ==========");
        Department dep = new Department(2, "Electronics");
        List<Seller> sellers = sellerDao.findByDepartment(dep);
        sellers.forEach(i -> System.out.println(i));
    }
}

/**
 * @author Seyda Ozer
 *
 */
public class Test {
	/**
	 * This main method of this application.
	 * @param args array of string arguments.
	 */
	public static void main(String[] args) {
			
		Branch b1 = new Branch("Gebze", "Kocaeli", 1);
		Branch b2 = new Branch("Darica", "Kocaeli", 2);
		Branch b3 = new Branch("Cayirova", "Kocaeli", 3);
			
		BranchEmployee e1 = new BranchEmployee("Gebze", "Kocaeli", b1.getBranchID(), "Ayse", "Kaya", 1);
		BranchEmployee e2 = new BranchEmployee("Gebze", "Kocaeli", b1.getBranchID(), "Guler", "Kaya", 2);
		BranchEmployee e3 = new BranchEmployee("Gebze", "Kocaeli", b1.getBranchID(), "Fatma", "Kaya", 3);
			
		TransportationPersonel p1 = new TransportationPersonel("Gebze", "Kocaeli", b1.getBranchID(), "Gamze", "Celik", 1);
		TransportationPersonel p2 = new TransportationPersonel("Gebze", "Kocaeli", b1.getBranchID(), "Hulya", "Celik", 2);
		TransportationPersonel p3 = new TransportationPersonel("Gebze", "Kocaeli", b1.getBranchID(), "Yaren", "Celik", 3);
			
		Package shipment1 = new Package("Ali", "Ayse", b1.getBranchID(), b1.getBranchName(), 1000);
		Package shipment2 = new Package("Fatma", "Hasan", b1.getBranchID(), b1.getBranchName(), 1001);
		Package shipment3 = new Package("Mehmet", "Cemal", b1.getBranchID(), b1.getBranchName(), 1002);
			
		Customer c1 = new Customer("Mustafa", "Demir", "Atalar", "05551112323", "11111111111");
		Customer c2 = new Customer("Alihan", "Kale", "Maltepe", "05552222323", "22222222222");
		Customer c3 = new Customer("Yasemin", "Gul", "Kadikoy", "05553332323", "33333333333");
			
		Company company = new Company();
			
		Administrator admin = new Administrator("Seyda", "Ozer");
		company.setAdmin(admin);
			
		//adding branch//
		company.getAdmin().addBranch(b1);
		company.getAdmin().addBranch(b2);
		company.getAdmin().addBranch(b3);
		System.out.println(company);
		company.getAdmin().addBranch(b1);
			
		//removing branch//
		company.getAdmin().removeBranch(b2);
		System.out.println(company);
		company.getAdmin().removeBranch(b2);
			
		try {
		//adding branch employee//
			company.getAdmin().addBranchEmployee(e1, company.getBranch(b1).getBranchID());
			company.getAdmin().addBranchEmployee(e2, company.getBranch(b1).getBranchID());
		}
		catch(Exception e) {
			System.out.println(e);
		}
		try {
			company.getAdmin().addBranchEmployee(e3, company.getBranch(b3).getBranchID());	
			System.out.println(company.getBranch(b1));
			System.out.println(company.getBranch(b3));
			company.getAdmin().addBranchEmployee(e1, company.getBranch(b1).getBranchID());
		//////////////////////////
			
		//removing branch employee//
			company.getAdmin().removeBranchEmployee(e2, company.getBranch(b1).getBranchID());
			System.out.println(company.getBranch(b1));
			company.getAdmin().removeBranchEmployee(e2, company.getBranch(b1).getBranchID());
		////////////////////////////
			
		//adding transportation personel//
			company.getAdmin().addTransportationPersonel(p1, company.getBranch(b1).getBranchID());
			company.getAdmin().addTransportationPersonel(p2, company.getBranch(b1).getBranchID());
			company.getAdmin().addTransportationPersonel(p3, company.getBranch(b3).getBranchID());
			System.out.println(company.getBranch(b1));
			System.out.println(company.getBranch(b3));
			company.getAdmin().addTransportationPersonel(p1, company.getBranch(b1).getBranchID());
		//////////////////////////////////
			
		//removing transportation personel//
			company.getAdmin().removeTransportationPersonel(p2, company.getBranch(b1).getBranchID());
			System.out.println(company.getBranch(b1));
			company.getAdmin().removeTransportationPersonel(p2, company.getBranch(b1).getBranchID());
		////////////////////////////////////
		}
		catch(Exception e) {
			System.out.println(e);
		}
		try {
		//adding shipment//
			company.getBranch(b1).getBranchEmployee(e1).addPackage(shipment1);
			company.getBranch(b1).getBranchEmployee(e1).addPackage(shipment2);
			company.getBranch(b1).getBranchEmployee(e1).addPackage(shipment3);
			System.out.println(company);
			company.getBranch(b1).getBranchEmployee(e1).addPackage(shipment2);
			
		//removing shipment//
			company.getBranch(b1).getBranchEmployee(e1).removePackage(shipment2.getTrackingNumber());
			System.out.println(company);
			company.getBranch(b1).getBranchEmployee(e1).removePackage(shipment2.getTrackingNumber());
	
		//adding customer//
			company.getBranch(b1).getBranchEmployee(e1).addCustomer(c1);
			company.getBranch(b1).getBranchEmployee(e1).addCustomer(c2);
			company.getBranch(b1).getBranchEmployee(e1).addCustomer(c3);
			System.out.println(company);
			company.getBranch(b1).getBranchEmployee(e1).addCustomer(c1);
			
		//removing customer//
			company.getBranch(b1).getBranchEmployee(e1).removeCustomer(c3.getSsn());
			System.out.println(company);
			company.getBranch(b1).getBranchEmployee(e1).removeCustomer(c3.getSsn());
		}
		catch(Exception e) {
			System.out.println(e);
		}
	
		//cargo tracking//
		c1.cargoTracking(shipment1.getTrackingNumber());
		c1.cargoTracking(shipment2.getTrackingNumber());

		try {
		//transfer//
			company.getBranch(b1).getBranchEmployee(e1).packageOutBranch(shipment1.getTrackingNumber(), b1.getBranchID());
			c1.cargoTracking(shipment1.getTrackingNumber());
			company.getBranch(b3).getBranchEmployee(e3).packageInBranch(shipment1.getTrackingNumber(), b3.getBranchID());
			c1.cargoTracking(shipment1.getTrackingNumber());
		}
		catch(Exception e) {
			System.out.println(e);
		}
		//delivered//
		try {
			company.getBranch(b3).getTransportationPersonel(p3).isDelivered(shipment1.getTrackingNumber());
			c1.cargoTracking(shipment1.getTrackingNumber());
		}	
		catch(Exception e) {
			System.out.println(e);
		}
	}
}

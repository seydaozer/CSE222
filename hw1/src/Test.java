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
		try {
			Company company = new Company();
			
			Branch b1 = new Branch("Gebze", "Kocaeli", 1);
			Branch b2 = new Branch("Darica", "Kocaeli", 2);
			Branch b3 = new Branch("Cayirova", "Kocaeli", 3);
			
			BranchEmployee e1 = new BranchEmployee("Gebze", "Kocaeli", b1.getID(), "Ayse", "Kaya", 1);
			BranchEmployee e2 = new BranchEmployee("Gebze", "Kocaeli", b1.getID(), "Guler", "Kaya", 2);
			BranchEmployee e3 = new BranchEmployee("Gebze", "Kocaeli", b1.getID(), "Fatma", "Kaya", 3);
			
			TransportationPersonel p1 = new TransportationPersonel("Gebze", "Kocaeli", b1.getID(), "Gamze", "Celik", 1);
			TransportationPersonel p2 = new TransportationPersonel("Gebze", "Kocaeli", b1.getID(), "Hulya", "Celik", 2);
			TransportationPersonel p3 = new TransportationPersonel("Gebze", "Kocaeli", b1.getID(), "Yaren", "Celik", 3);
			
			Administrator admin = new Administrator("Seyda", "Ozer");
			company.setAdmin(admin);
			
			//adding branch
			company.getAdmin().addBranch(b1);
			company.getAdmin().addBranch(b2);
			company.getAdmin().addBranch(b3);
			System.out.println(company);
			company.getAdmin().addBranch(b1);
				
			//remmoving branch
			company.getAdmin().removeBranch(b2);
			System.out.println(company);
			company.getAdmin().removeBranch(b2);
			
			//adding branch employee
			company.getAdmin().addBranchEmployee(e1, b1.getID());
			company.getAdmin().addBranchEmployee(e2, b1.getID());
			company.getAdmin().addBranchEmployee(e3, b3.getID());
			System.out.println(b1);
			System.out.println(b3);
			company.getAdmin().addBranchEmployee(e1, b1.getID());
				
			//remmoving branch employee
			company.getAdmin().removeBranchEmployee(e2, b1.getID());
			System.out.println(b1);
			company.getAdmin().removeBranchEmployee(e2, b1.getID());
				
			//adding transportation personel
			company.getAdmin().addTransportationPersonel(p1, b1.getID());
			company.getAdmin().addTransportationPersonel(p2, b1.getID());
			company.getAdmin().addTransportationPersonel(p3, b3.getID());
			System.out.println(b1);
			System.out.println(b3);
			company.getAdmin().addTransportationPersonel(p1, b1.getID());
				
			//removing transportation personel
			company.getAdmin().removeTransportationPersonel(p2, b1.getID());
			System.out.println(b1);
			company.getAdmin().removeTransportationPersonel(p2, b1.getID());
		
			//adding shipment
			Package shipment1 = new Package("Ali", "Ayse", b1.getID(), b1.getName(), 1000);
			Package shipment2 = new Package("Fatma", "Hasan", b1.getID(), b1.getName(), 1001);
			Package shipment3 = new Package("Mehmet", "Cemal", b1.getID(), b1.getName(), 1002);
			b1.getBranchEmployee(e1.getID()).addPackage(shipment1);
			b1.getBranchEmployee(e1.getID()).addPackage(shipment2);
			b1.getBranchEmployee(e1.getID()).addPackage(shipment3);
			System.out.println(company);
			b1.getBranchEmployee(e1.getID()).addPackage(shipment2);
			
			//removing shipment
			b1.getBranchEmployee(e1.getID()).removePackage(shipment2.getTrackingNumber());
			System.out.println(company);
			b1.getBranchEmployee(e1.getID()).removePackage(shipment2.getTrackingNumber());
			
			//adding customer
			Customer c1 = new Customer("Mustafa", "Demir", "Atalar", "05551112323", "11111111111");
			Customer c2 = new Customer("Alihan", "Kale", "Maltepe", "05552222323", "22222222222");
			Customer c3 = new Customer("Yasemin", "Gul", "Kadikoy", "05553332323", "3333333333");
			b1.getBranchEmployee(e1.getID()).addCustomer(c1);
			b1.getBranchEmployee(e1.getID()).addCustomer(c2);
			b1.getBranchEmployee(e1.getID()).addCustomer(c3);
			System.out.println(company);
			b1.getBranchEmployee(e1.getID()).addCustomer(c2);
			
			//removing customer
			b1.getBranchEmployee(e1.getID()).removeCustomer(c3.getSsn());
			System.out.println(company);
			b1.getBranchEmployee(e1.getID()).removeCustomer(c3.getSsn());
			
			//cargo tracking
			company.getCustomer(c1.getSsn()).cargoTracking(shipment1.getTrackingNumber());
			company.getCustomer(c1.getSsn()).cargoTracking(shipment2.getTrackingNumber());
			//transfer
			b1.getBranchEmployee(e1.getID()).packageOutBranch(shipment1.getTrackingNumber(), b1.getID());
			company.getCustomer(c1.getSsn()).cargoTracking(shipment1.getTrackingNumber());
			b3.getBranchEmployee(e3.getID()).packageInBranch(shipment1.getTrackingNumber(), b3.getID());
			company.getCustomer(c1.getSsn()).cargoTracking(shipment1.getTrackingNumber());
			//delivered
			b3.getTransportationPersonel(p3.getID()).isDelivered(shipment1.getTrackingNumber());
			company.getCustomer(c1.getSsn()).cargoTracking(shipment1.getTrackingNumber());
			
		}	
		catch(Exception e) {
			System.out.println(e);
		}
	}

}

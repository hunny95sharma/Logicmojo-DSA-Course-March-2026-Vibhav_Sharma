package recursion;

public class TowerOfHanoi {

	public static void towerOfHanoi(int disks, char source, char auxiliary, char destination) {
		if(disks==0)
			return;
		
		towerOfHanoiHelper(disks,'a','b','c');
	}
	
	public static void towerOfHanoiHelper(int disks, char source, char auxiliary, char destination) {
		if(disks==0)
			return;
		towerOfHanoiHelper(disks-1,source,destination,auxiliary);
		System.out.println(source+" "+destination);
		towerOfHanoiHelper(disks-1,auxiliary,source,destination);
	}
	
}
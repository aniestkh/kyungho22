import java.util.ArrayList;
import java.util.Scanner;

public class exc {
	static Scanner s1=new Scanner(System.in); // 문자열
	static Scanner s2=new Scanner(System.in); // 정수
	static ArrayList<Integer> Price=new ArrayList<Integer>();
	static ArrayList<String> Menu=new ArrayList<String>();
	static ArrayList<Integer> Count=new ArrayList<Integer>();
	static ArrayList<Integer> totalPrice=new ArrayList<Integer>();
	static ArrayList<String> jangbasketMenu=new ArrayList<String>();
	static ArrayList<Integer> jangPrice=new ArrayList<Integer>();
	static ArrayList<Integer> jangCount=new ArrayList<Integer>();
	static ArrayList<Integer> menuTotalPrice=new ArrayList<Integer>();
	static ArrayList<Integer> Order=new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		// 과제1. 정수형 배열
		
//		int[] arNum=new int[5];
//		int i;
//		
//		for(i=0;i<arNum.length;i++) {
//			arNum[i]=(i+1)*10;
//			System.out.print(arNum[i]+" ");
//		}
//		System.out.println();
//		System.out.println("------------------------");
		
		
		// 과제2. 빈문자열 나올때까지 입력
		
//		ArrayList<String> str=new ArrayList<String>();
//		Scanner s1=new Scanner(System.in);
//		
//		String input;
//		
//		for(;true;) {
//			System.out.print("문자를 입력하세요: ");
//			input=s1.nextLine();
//			if(input.equals("")) break;
//			str.add(input);
//			System.out.println(str);
//		}
	
		
		// 연습 parseInt
		
//		String num="123";
//		int result;
//		
//		System.out.println(num+10);
//		System.out.println("------------");
//		result=Integer.parseInt(num);
//		System.out.println(result+10);
		
		
		// 연습 isNaN()
		
//		int x;
//		Double y;
//		
//		x=20;
//		y=25.2;
//				
//		System.out.println(x+y);
//		System.out.println("---------");
//		System.out.println(Double.isNaN(x+y));
//				
//	}
//	public static boolean isNumber(String str) {
//		return str.matches("-?\\d*(\\.\\d+)?");
//	}

		//while(true) {
	    // 메뉴목록보기
	    // 안내 - 주문할 메뉴번호 선택 (0:종료)
	    // 주문번호 입력
	    // 안내 - 수량 입력(0:종료)
	    // 주문수량 입력
	    // 출력 - 선택한 메뉴명 x 수량 = 금액
	    // 주문내역 저장 - 메뉴명, 수량, 금액
		//}
		
		
	// 전체주문내역 출력
	// 주문총액 출력
		String enter;
		for(;true;) {
			System.out.println("원하시는 작업의 번호를 입력하세요");
			System.out.println("[1: 메뉴추가, 2: 전체메뉴, 3: 주문하기, 4: 주문총액, 0: 종료]");
			enter=s1.nextLine();
			
			switch(enter) {
			case "1":
				addMenu();
				System.out.println();
				break;
			case "2":
				seeMenu();
				System.out.println();
				break;
			case "3":
				menuOrder();
				System.out.println();
				System.out.println("주문을 종료합니다.");
				System.exit(0);
				break;
			case "4":
				totalOrder(jangbasketMenu, jangPrice, jangCount);
				System.out.println();
				System.out.println("주문을 종료합니다.");
				System.exit(0);
				break;
			case "0":
				System.out.println("주문을 종료합니다.");
				System.exit(0);
			
			case "":
//				System.out.println("주문을 종료합니다.");
				break;
			}
			
		}
		
	}
	
	public static void addMenu() {
		String inputMenu;
		int inputPrice, inputCount;
		
		for(;true;) {
			System.out.print("메뉴명을 입력하세요: ");
			inputMenu=s1.nextLine();
			if(inputMenu.equals("")) break;
			System.out.print("단가를 입력하세요: ");
			inputPrice=s2.nextInt();
			if(inputPrice==0) break;
			System.out.print("수량을 입력하세요: ");
			inputCount=s2.nextInt();
//			if(inputCount.equals("")) { 			// 정수형에 빈문자 입력될 경우 빈문자 출력
//				inputCout.euals("재고없음");
//			}
			
			Menu.add(inputMenu);
			Price.add(inputPrice);
			Count.add(inputCount);
			totalPrice.add(inputPrice*inputCount);
		}
		System.out.println("----------------");
		System.out.print("메뉴명: ");
		System.out.println(Menu);
		System.out.print("단가: ");
		System.out.println(Price);
		System.out.print("재고: ");
		System.out.println(Count);
	}
	
	public static void seeMenu() {
		System.out.println("상품명 단가 수량 금액");
		for(int i=0;i<Menu.size();i++) {
			
			System.out.println((i+1)+" "+Menu.get(i)+" "+Price.get(i)+" "+Count.get(i)+" "+totalPrice.get(i));
		}
		
	}
	
	public static void menuOrder() {
		int count;
		String choice;
		
		seeMenu();
		System.out.println("원하는 메뉴의 상품번호를 선택하세요");
		
		for(;true;) {
			int menutotalprice;
			System.out.println("[숫자입력: 상품선택, 0: 전체주문, x: 종료]");
			choice=s1.nextLine();
			if(choice.equals("0")){
				totalOrder(jangbasketMenu, jangPrice, jangCount);
				break;
			} else if(choice.equals("x")) {
				break;
			} else {
				System.out.println(Menu.get(Integer.parseInt(choice)-1)+" "+Price.get(Integer.parseInt(choice)-1));
				System.out.println("구매수량을 입력하세요");
				for(;true;) {
					count=s2.nextInt();
					if(count>Count.get(0)) {
						System.out.println("선택 수량이 재고 수량을 넘어갑니다. 다시 입력하세요.");
					}else {
						System.out.println(count+"개");
						jangbasketMenu.add(Menu.get(Integer.parseInt(choice)-1));
						jangPrice.add(Price.get(Integer.parseInt(choice)-1));
						jangCount.add(count);
						menutotalprice=Price.get(Integer.parseInt(choice)-1)*count;
						menuTotalPrice.add(menutotalprice);
						break;
					}
					}	
				}
		}
	}
	
	public static void totalOrder(ArrayList<String> jangbasketMenu, ArrayList<Integer> jangPrice, ArrayList<Integer> jangCount) {
		int i, order=0;
		String k;
		
		System.out.println("주문하실 상품 목록을 확인해주세요");
		for(i=0;i<jangbasketMenu.size();i++) {
			System.out.println(jangbasketMenu.get(i)+" "+jangPrice.get(i)+"원 "+"x"+jangCount.get(i)+"개"+"="
			+(jangPrice.get(i)*jangCount.get(i))+"원");
			order+=(jangPrice.get(i)*jangCount.get(i));
		}
		System.out.println("주문하시겠습니까?");
		System.out.println("[y: 주문하기, n: 취소하기]");
		for(;true;) {
			k=s1.nextLine();
			if(k.equals("y")) {
				System.out.println("-----------------");
				System.out.println("총 금액: "+order+"원");
			} else if(k.equals("n")) {
				break;
			} else {
				System.out.println("다시 입력해주세요.");
			}
		}
	}
	
	
}

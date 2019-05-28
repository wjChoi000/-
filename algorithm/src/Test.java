
public class Test {

	public static void main(String args[]) {
		int num =0,num2=0;;
		
		String str=	"hk003130@naver.com<hk003130@naver.com>, solip6732@nate.com<solip6732@nate.com>, bosuksh@gmail.com<bosuksh@gmail.com>, dltnsehd99@naver.com<dltnsehd99@naver.com>, jeon3029@naver.com<jeon3029@naver.com>, jsb9344@naver.com<jsb9344@naver.com>, lonecitizen@naver.com<lonecitizen@naver.com>, acu.pe.kr@gmail.com<acu.pe.kr@gmail.com>, anthlife79@gmail.com<anthlife79@gmail.com>, dhksrl2589@gmail.com<dhksrl2589@gmail.com>, iniv2@naver.com<iniv2@naver.com>, jhi1432@gmail.com<jhi1432@gmail.com>, kimchdh1@gmail.com<kimchdh1@gmail.com>, oh27919@naver.com<oh27919@naver.com>, j0238@naver.com<j0238@naver.com>, ko92go@gmail.com<ko92go@gmail.com>, but.i.am.soyoung@gmail.com<but.i.am.soyoung@gmail.com>, e_manu@naver.com<e_manu@naver.com>, jh82588258@gmail.com<jh82588258@gmail.com>, khay0311@daum.net<khay0311@daum.net>, nadaadhj@gmail.com<nadaadhj@gmail.com>, aasdddfd111@gmail.com<aasdddfd111@gmail.com>, dutls4554@naver.com<dutls4554@naver.com>, benedictu5@naver.com<benedictu5@naver.com>, dldbstn1047@gmail.com<dldbstn1047@gmail.com>, jack.ohjoonoh@gmail.com<jack.ohjoonoh@gmail.com>, jiyoon075@gmail.com<jiyoon075@gmail.com>, leesj9476@naver.com<leesj9476@naver.com>, shrntg@naver.com<shrntg@naver.com>, 90honeypot@gmail.com<90honeypot@gmail.com>, dcj4655@naver.com<dcj4655@naver.com>, gm_zzz@naver.com<gm_zzz@naver.com>, jhh5154@naver.com<jhh5154@naver.com>, kimblme@naver.com<kimblme@naver.com>, nyu531@naver.com<nyu531@naver.com>, codingple@hanyang.ac.kr<codingple@hanyang.ac.kr>, freshstandpoint@gmail.com<freshstandpoint@gmail.com>, blue_power@naver.com<blue_power@naver.com>, dlstjd0117@ajou.ac.kr<dlstjd0117@ajou.ac.kr>, jaewook5454@naver.com<jaewook5454@naver.com>, jng0820@naver.com<jng0820@naver.com>, lhnw7662@naver.com<lhnw7662@naver.com>, rlawns1016@naver.com<rlawns1016@naver.com>, swelo12@naver.com<swelo12@naver.com>, a71858870@gmail.com<a71858870@gmail.com>, sybang0322@gmail.com<sybang0322@gmail.com>, beensoobak@gmail.com<beensoobak@gmail.com>, hclove61@gmail.com<hclove61@gmail.com>, j18num@naver.com<j18num@naver.com>, uugg2922@gmail.com<uugg2922@gmail.com>, seoungjong@naver.com<seoungjong@naver.com>, official.hoony813@gmail.com<official.hoony813@gmail.com>, inwonnam@gmail.com<inwonnam@gmail.com>, hyeaaaa@naver.com<hyeaaaa@naver.com>, rohi040404@gmail.com<rohi040404@gmail.com>, ted6345@gmail.com<ted6345@gmail.com>, ahdcoqls@ajou.ac.kr<ahdcoqls@ajou.ac.kr>, heunb94@gmail.com<heunb94@gmail.com>, crossroaded@gmail.com<crossroaded@gmail.com>, klnph1017@naver.com<klnph1017@naver.com>, passorang@naver.com<passorang@naver.com>, sjjwjj@naver.com<sjjwjj@naver.com>, vs223@naver.com<vs223@naver.com>, shwjdgh34@gmail.com<shwjdgh34@gmail.com>, poetish@kaist.ac.kr<poetish@kaist.ac.kr>, whdlrghks0314@gmail.com<whdlrghks0314@gmail.com>, silver2473@naver.com<silver2473@naver.com>, ser_a@naver.com<ser_a@naver.com>, tkwpvk789@gmail.com<tkwpvk789@gmail.com>, odh93@naver.com<odh93@naver.com>, junsix99@gmail.com<junsix99@gmail.com>, comisputer@gmail.com<comisputer@gmail.com>, tom558@naver.com<tom558@naver.com>, ridgnfu@naver.com<ridgnfu@naver.com>, sonmj426@gmail.com<sonmj426@gmail.com>, wodlf1212@hanyang.ac.kr<wodlf1212@hanyang.ac.kr>, sonyy1591@gmail.com<sonyy1591@gmail.com>, yusinshin@gmail.com<yusinshin@gmail.com>, inyong41@gmail.com<inyong41@gmail.com>, wizet1923@naver.com<wizet1923@naver.com>";
		for(int i=0; i<str.length();i++) {
			if(str.charAt(i)=='@')
				num++;
			if(str.charAt(i)=='<')
				num2++;
		}
		System.out.println(num);
		System.out.println(num2);
		
		
		
//		Animal a1 = new  Animal(1);
//		Animal a2 = new Animal(1);
//		Animal a3 = a1;
//		
//		System.out.println("a1==a2: "+(a1==a2) );
//		System.out.println("a1==a3: "+(a1==a3) );
//		
//		System.out.println("equals a1,a1: "+a1.equals(a1) );
//		System.out.println("equals a1,a2: "+a1.equals(a2) );
//		System.out.println("equals a1,a3: "+a1.equals(a3) );
//	
//		System.out.println("a1 hashCode"+a1.hashCode());
//		System.out.println("a2 hashCode"+a2.hashCode());
//		System.out.println("a3 hashCode"+a3.hashCode());
//		
//		
//		System.out.println("\nOverride ÈÄ");
//		
//		Animal2 b1 = new Animal2(1);
//		Animal2 b2 = new Animal2(1);
//		System.out.println("b1 == b2: "+(b1 ==b2));
//		System.out.println("equals b1,b2: "+b1.equals(b2));
//		System.out.println("hashcode b1: "+b1.hashCode());
//		System.out.println("hashcode b2: "+b2.hashCode());
		
	}

}

class Animal{
	int a;
	public Animal(int a) {
		this.a = a;
	}
}


class Animal2{
	int a;
	public Animal2(int a) {
		this.a = a;
	}
	@Override
	public boolean equals(Object t) {
		if(t == null)
			return false;
		if(this.getClass() !=t.getClass())
			return false;
		Animal2 that = (Animal2)t;
		if(this.a == that.a)
			return true;
		else 
			return false;
	}
}

import java.util.*;
class UpgradProblem{
	public static void main(String args[]) throws Exception{
		Scanner sc=new Scanner(System.in);
		String name,event;
		double cgpa;
		int tokenID,total_events;
		total_events=sc.nextInt();
		PriorityQueue<Pupil> pq = new PriorityQueue<>(3*total_events,new Comparator<Pupil>(){
			@Override
			public int compare(Pupil one,Pupil two){
				if(one.cgpa>two.cgpa){
					return -1;
				}
				else if(one.cgpa<two.cgpa){
					return 1;
				}
				else{
					int comp=(one.name).compareTo(two.name);
					if(comp<0){
						return -1;
					}
					else if(comp>0){
						return 1;
					}
					else{
						if(one.tokenID<two.tokenID){
							return -1;
						}
						else if(one.tokenID<two.tokenID){
							return 1;
						}
					}
				}
				return 0;
			}
		});
		for(int i=0;i<total_events;i++){
			event=sc.next();
			if(event.equals("ENTER")){
				name=sc.next();
				cgpa=sc.nextDouble();
				tokenID=sc.nextInt();
				pq.add(new Pupil(name,tokenID,cgpa));
			}
			else if(event.equals("SERVED")){
				pq.poll();
			}
		}
		if(pq.isEmpty()){
			System.out.println("EMPTY");
		}
		else{
			while(!pq.isEmpty()){
        		System.out.println(""+pq.poll().nameOfPupil());
        	}
		}
	}
}
class Pupil{
	String name;
	int tokenID;
	double cgpa;
	public Pupil(String name,int tokenID,double cgpa){
		this.name=name;
		this.cgpa=cgpa;
		this.tokenID=tokenID;
	}
	String nameOfPupil(){
		return name;
	}
}
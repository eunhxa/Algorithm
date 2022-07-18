import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class Group {
    int A;
    int B;
    int C;
    Group(int A, int B, int C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }
    @Override
    public int hashCode() {
        return (this.A+" "+this.B+" "+this.C).hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Group) {
            Group g = (Group)obj;
            // return this.hashCode()==g.hashCode(); 
            return (this.A == g.A && this.B == g.B && this.C == g.C);
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        Queue<Group> q = new LinkedList<>();
        Set<Group> set = new HashSet<Group>();

        q.add(new Group(A, B, C));
        set.add(new Group(A, B, C));
        while(!q.isEmpty()) {
            Group g = q.poll();
            int a = g.A;
            int b = g.B;
            int c = g.C;

            if(a == b && b == c) {
                System.out.println(1);
                System.exit(0);
            }

            if(a != b) {
                if(a > b) {
                    int size = set.size();
                    Group tmpGroup = new Group(a-b, b+b, c);
                    set.add(tmpGroup);
                    if(set.size() > size) {
                        q.offer(tmpGroup);
                    }
                } else {
                    int size = set.size();
                    Group tmpGroup = new Group(a+a, b-a, c);
                    set.add(tmpGroup);
                    if(set.size() > size) {
                        q.offer(tmpGroup);
                    }
                }
            }
            if(a != c) {
                if(a > c) {
                    int size = set.size();
                    Group tmpGroup = new Group(a-c, b, c+c);
                    set.add(tmpGroup);
                    if(set.size() > size) {
                        q.offer(tmpGroup);
                    }
                } else {
                    int size = set.size();
                    Group tmpGroup = new Group(a+a, b, c-a);
                    set.add(tmpGroup);
                    if(set.size() > size) {
                        q.offer(tmpGroup);
                    }
                }
            }
            if(b != c) {
                if(b > c) {
                    int size = set.size();
                    Group tmpGroup = new Group(a, b-c, c+c);
                    set.add(tmpGroup);
                    if(set.size() > size) {
                        q.offer(tmpGroup);
                    }
                } else {
                    int size = set.size();
                    Group tmpGroup = new Group(a, b+b, c-b);
                    set.add(tmpGroup);
                    if(set.size() > size) {
                        q.offer(tmpGroup);
                    }
                }
            }
        }
        System.out.println(0);
    }
}
import java.util.*;

class Person
{
    public String name;

    public Person(String name)
    {
        this.name = name;
    }

}

enum Relationship
{
    PARENT,
    CHILD,
    SIBLING
}

class Triplet<T, U, V>
{
    private final T first;
    private final U second;
    private final V third;

    public Triplet(T first, U second, V third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getValue0() 
    {
        return first;
    }

    public U getValue1() 
    {
        return second;
    }

    public V getValue2() 
    {
        return third;
    }
}

class Relationships implements RelationshipBrowser
{
    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();

    public List<Triplet<Person, Relationship, Person>> getRelations()
    {
        return relations;
    } 

    public void addParentAndChild(Person parent, Person child)
    {
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    public List<Person> findAllChildrenOf(String name)
    {
        List<Person> list = new ArrayList<>();
        for (int i=0; i < relations.size(); i++)
        {
            if(relations.get(i).getValue0().name.equals(name)&& relations.get(i).getValue1() == Relationship.PARENT)
            {
               list.add(relations.get(i).getValue2());
            }
        }
        return list;
    }
}

class Research
{
    public Research(Relationships relationships, Person person)
    {
        //high-level find all of persion's children

        // List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
        // relations.stream().filter(x -> x.getValue0().name.equals("John")
        //     && x.getValue1() == Relationship.PARENT).forEach(ch -> System.out.println("John has a child called " +ch.getValue2().name));

        List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();

        for (int i=0; i < relations.size(); i++)
        {
            if(relations.get(i).getValue0().name.equals(person.name)&& relations.get(i).getValue1() == Relationship.PARENT)
            {
                System.out.println(person.name +" has a child called "+relations.get(i).getValue2().name);
            }
        }
    }


}

/////
interface RelationshipBrowser
{
     List<Person> findAllChildrenOf(String name);
}


class SOLID_D
{
    public static void main(String[] args)
    {
        Person parent = new Person("John");
        Person child1 = new Person("Chris");
        Person child2 = new Person("Matt");

        //low-level module
        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent, child1);
        relationships.addParentAndChild(parent, child2);

        new Research(relationships,parent);

        List<Person> johnChildren  = relationships.findAllChildrenOf(parent.name);
        for(Person person : johnChildren)
        {
            System.out.println(parent.name +" has a child called "+person.name);
        }
    }
}

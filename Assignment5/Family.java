import java.util.ArrayList;

class Family {
    ArrayList<Person> family = new ArrayList<Person>();

    public void addPerson(String name, int parent1, int parent2) {
        //This method adds a person to the tree.
        family.add(new Person(name,parent1,parent2));
    }

    public int getIDFromName(String name) {
        //This method converts a name to an id
        for(Person x : family) {
            if(x.getName()==name) {
                return x.getID();
            }
        }
        return -1;
    }

    public String getNameFromID(int id) {
        //This method converts an id to a name.
        for(Person x : family) {
            if(x.getID()==id) {
                return x.getName();
            }
        }
        return "Unknown";
    }

    public String parentRelationship(String current) {
        //This method calculates the word for a parent, grandparent, great-grandparent etc.
        if(current.equals("Self")) {
            return "Parent";
        }
        else if(current.equals("Parent")) {
            return "GrandParent";
        }
        else {
            return "Great "+current;
        }
    }

    public String childRelationship(String current) {
        //This method calculates the word for a child, grandchild, great-grandchild etc.
        if(current.equals("Self")) {
            return "Child";
        }
        else if(current.equals("Child")) {
            return "GrandChild";
        }
        else {
            return "Great "+current;
        }
    }

    public String everyone() {
        String returnString="";
        for(Person x : family) {
            returnString+=x.getID()+") "+x.getName()+"\n";
        }
        return returnString;
    }

    public ArrayList<Integer> getChildrenIDs(int id) {
        ArrayList<Integer> childrenIDs = new ArrayList<>();
        for (Person person : family) {
            if (person.getParent1() == id || person.getParent2() == id) {
                if (!childrenIDs.contains(person.getID())) {
                    childrenIDs.add(person.getID());
    }}}
    return childrenIDs;
    }

    public int[] getParents(int ID) {
        for (Person person : family) {
            if (person.getID() == ID) {
                return new int[]{person.getParent1(), person.getParent2()};
            }
        }
        return new int[]{-1, -1}; // Assuming no parent found
    }

    public void printParents(int childID, String relationship) {
        if (childID == -1) {
            return;
        }
        Person child = null;
        for (Person person : family) {
            if (person.getID() == childID) {
                child = person;
                break;
            }
        }
        if (child != null) {
            System.out.println(relationship + " " + child.getName());
            int[] parents = getParents(childID);
            printParents(parents[0], parentRelationship(relationship));
            printParents(parents[1], parentRelationship(relationship));
        }
    }

    public void printChildren(int parentID, String relationship) {
        ArrayList<Integer> childrenIDs = getChildrenIDs(parentID);
        for (int childID : childrenIDs) {
            Person child = null;
            for (Person person : family) {
                if (person.getID() == childID) {
                    child = person;
                    break;
                }
            }
            if (child != null) {
                System.out.println(relationship + " " + child.getName());
                printChildren(childID, childRelationship(relationship));
            }
        }
    }
}
package app;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DbManager {

    private final String PATH = "src/data/info.txt";

    private static DbManager instace;
    private List<User> users = new ArrayList<User>();

    public static DbManager getInstance(){
        if(instace == null) instace = new DbManager();
        return instace;
    }

    public User createUser(int id) throws Exception{
        User user = new User(id, 0);
        users.add(user);

        String info = id + "_" + 0.0 + "\n";
        File out = new File(PATH);
        FileOutputStream output = new FileOutputStream(out, true);
        output.write(info.getBytes());
        output.close();

        return user;
    }

    public void updateData(int id, double money) throws Exception{
        FileWriter writer = new FileWriter(PATH);

        String update = id + "_" + money;
        String old = "";
        String sc = "";

        for(User u : users){
            if(u.getId() == id) old = u.getId() + "_" + u.getMoney();
            String same = u.getId() + "_" + u.getMoney();
            sc = sc + same + System.lineSeparator();
        }

        String updateInfo = sc.replaceAll(old, update);
        writer.write(updateInfo);

        writer.close();
    }

    public void loadData() throws Exception{
        users.clear();

        BufferedReader reader = new BufferedReader(new FileReader(PATH));
        String line = reader.readLine();

        while(line != null){
            String[] sp = line.split("_");
            users.add(new User(Integer.parseInt(sp[0]), Double.parseDouble(sp[1])));
            line = reader.readLine();
        }

        reader.close();
    }

    public User findUser(int id){
        for(User u : users){
            if(u.getId() == id) return u;
        }

        return null;
    }

}

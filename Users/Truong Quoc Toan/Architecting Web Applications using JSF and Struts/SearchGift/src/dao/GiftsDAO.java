package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.Gift;

public class GiftsDAO {

    public GiftsDAO() {
        // TODO Auto-generated constructor stub
    }
    
    public static ArrayList<Gift> getAllGifts() {
        ArrayList<Gift> gifts = new ArrayList<Gift>();
        try {
            PreparedStatement statement = DataUtil.getConnection().prepareStatement("SELECT [ID], [Name], [Price], [Quantity] FROM [Gifts] WHERE [Quantity]>0");
            ResultSet rs = statement.executeQuery();
            Gift gift = null;
            while (rs.next()) {
                gift = new Gift();
                gift.setId(rs.getInt("ID"));
                gift.setName(rs.getString("Name"));
                gift.setPrice(rs.getInt("Price"));
                gift.setQuantity(rs.getInt("Quantity"));
                gifts.add(gift);
            }
            return gifts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<Gift> Search(String name) {
        ArrayList<Gift> gifts = new ArrayList<Gift>();
        try {
            PreparedStatement statement = DataUtil.getConnection().prepareStatement("SELECT [ID], [Name], [Price], [Quantity] FROM [Gifts] WHERE [Name]=?");
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            Gift gift = null;
            while (rs.next()) {
                gift = new Gift();
                gift.setId(rs.getInt("ID"));
                gift.setName(rs.getString("Name"));
                gift.setPrice(rs.getInt("Price"));
                gift.setQuantity(rs.getInt("Quantity"));
                gifts.add(gift);
            }
            return gifts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

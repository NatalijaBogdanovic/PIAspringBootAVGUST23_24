package com.example.backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Repo {

    public Korisnik login(Korisnik k){
        try (Connection con = DB.source().getConnection();
        PreparedStatement stm = con.prepareStatement("select * from korisnici where kor_ime=? and lozinka=? ");) {
            stm.setString(1, k.getKor_ime());
            stm.setString(2, k.getLozinka());
            ResultSet rs= stm.executeQuery();
            if(rs.next()){
                return new Korisnik(rs.getString("kor_ime"), rs.getString("lozinka"), rs.getString("ime"), rs.getString("prezime"), rs.getString("mejl"), rs.getString("tip"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public List<Igre> dohvOtvoreneIgre(){
         try (Connection con = DB.source().getConnection();
        PreparedStatement stm = con.prepareStatement("select * from igre where status=? ");) {
            stm.setString(1, "otvorena");
            ResultSet rs= stm.executeQuery();
            List<Igre> igre= new ArrayList<>();
            while(rs.next()){
                igre.add(new Igre(rs.getString("naziv"), rs.getString("trenutno_pridruzeni"), rs.getInt("min"), rs.getInt("max"), rs.getString("status")));
            }
            return igre;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }
    public List<Igre> dohvSveIgre() {
        try (Connection con = DB.source().getConnection();
        PreparedStatement stm = con.prepareStatement("select * from igre order by naziv asc ");) {
            ResultSet rs= stm.executeQuery();
            List<Igre> igre= new ArrayList<>();
            while(rs.next()){
                igre.add(new Igre(rs.getString("naziv"), rs.getString("trenutno_pridruzeni"), rs.getInt("min"), rs.getInt("max"), rs.getString("status")));
            }
            return igre;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }
    public Igre pridruziseIgri(Korisnik igrac, String naziv) {
        try (Connection con = DB.source().getConnection();
        PreparedStatement stm = con.prepareStatement("update igre set trenutno_pridruzeni = CONCAT(trenutno_pridruzeni, ',', ?) where naziv=? and trenutno_pridruzeni not like concat('%', ?, '%') ");) {
            stm.setString(1, igrac.getKor_ime());
            stm.setString(2, naziv);
            stm.setString(3, igrac.getKor_ime());
            stm.executeUpdate();

            try(PreparedStatement stm2 = con.prepareStatement("select * from igre where naziv=? ");){
                stm2.setString(1, naziv);
                
                ResultSet rs= stm2.executeQuery();
                if(rs.next()){
                    return new Igre(rs.getString("naziv"), rs.getString("trenutno_pridruzeni"), rs.getInt("min"), rs.getInt("max"), rs.getString("naziv"));
                }
                return null;

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
        
    }

    public List<Poruke> prikaziPoruke(String ulogovani, String izabrani){
        try (Connection con = DB.source().getConnection();
        PreparedStatement stm = con.prepareStatement("select * from poruke where (igrac1=? and igrac2=?) or (igrac1=? and igrac2=?) ");) {
            stm.setString(1, ulogovani);
            stm.setString(2, izabrani);
            stm.setString(3, izabrani);
            stm.setString(4, ulogovani);

            ResultSet rs= stm.executeQuery();
            List<Poruke> poruke= new ArrayList<>();
            while(rs.next()){
                poruke.add(new Poruke(rs.getInt("idP"), rs.getString("igra"), rs.getString("igrac1"), rs.getString("igrac2"), rs.getString("tekst")));
            }
            return poruke;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

    public void dodajPoruku(String poruka, String igra, String izabrani, String ulogovani){
         try (Connection con = DB.source().getConnection();
        PreparedStatement stm = con.prepareStatement("insert into poruke (igra, igrac1, igrac2, tekst) values (?, ?, ?, ?) ");) {
            stm.setString(1, igra);
            stm.setString(2, ulogovani);
            stm.setString(3, izabrani);
            stm.setString(4, poruka);
            stm.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public void promeniStatus(String naziv) {
        try (Connection con = DB.source().getConnection();
        PreparedStatement stm = con.prepareStatement("update igre set status=? where naziv=? ");) {
            stm.setString(1, "zapoceta");
            stm.setString(2, naziv);
            stm.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
       public void resetujIgru(String naziv) {
        try (Connection con = DB.source().getConnection();
        PreparedStatement stm = con.prepareStatement("update igre set trenutno_pridruzeni=?, status=? where naziv=? ");) {
            stm.setString(1, "");
            stm.setString(2, "otvorena");
            stm.setString(3, naziv);
            stm.executeUpdate();

            try (PreparedStatement stm2 = con.prepareStatement("delete from poruke where igra=? ");) {
                stm2.setString(1, naziv);
                stm2.executeUpdate();
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
       public void dodajIgru(Igre i) {
          try (Connection con = DB.source().getConnection();
        PreparedStatement stm = con.prepareStatement("insert into igre (naziv, trenutno_pridruzeni, min, max, status) values (?, ?, ?, ?, ?) ");) {
            stm.setString(1, i.getNaziv());
            stm.setString(2, i.getTrenutno_pridruzeni());
            stm.setInt(3, i.getMin());
            stm.setInt(4, i.getMax());
            stm.setString(5, i.getStatus());
            stm.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       }
    
    
}

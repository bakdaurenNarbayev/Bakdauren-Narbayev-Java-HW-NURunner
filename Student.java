
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;


public class Student extends Entity {
    public int grade;
    private final String[] csci235StudentNames =
  {
    "Abay" , "Abilda" , "Abilkhaiyr" , "Ablan" , "Abylaikhan" , "Adil" , "Adilzhan" , "Adlet" , "Aidana" , "Aidyn" , "Aigerim" , "Aisana" ,
    "Akhmed" , "Akmyrza" , "Alan" , "Aldamzhar" , "Alexandra" , "Ali" , "Alibek" , "Alim" , "Alisher" , "Allan" , "Altair" , "Altynay" ,
    "Altynbek" , "Amangeldy" , "Amina" , "Anel" , "Angsar" , "Anuar" , "Ardan" , "Arman" , "Askhat" , "Assanali" , "Assem" , "Ayazhan" ,
    "Azamat" , "Azizkhan" , "Bagdat" , "Baglan" , "Bakdaulet" , "Bakdauren" , "Bakyt" , "Batyrbek" , "Batyrkhan" , "Bauyrzhan" , "Beibarys" ,
    "Bekzat" , "Bota" , "Damir" , "Dana" , "Danel" , "Daniyar" , "Darina" , "Dastan" , "Daulet" , "Dauren" , "Dnislam" , "Dulat" , "Eldar" ,
    "Emir" , "Galym" , "Gulnaz" , "Islam" , "Kamila" , "Kamilla" , "Karim" , "Kassym" , "Khadisha" , "Khafiz" , "Kuanysh" , "Kyran" , "Madi" ,
    "Madiyar" , "Magzhan" , "Makhambet" , "Mansur" , "Margulan" , "Maxim" , "Medet" , "Meirzhan" , "Miras" , "Mokhira" , "Murat" , "Nargiza" ,
    "Nartay" , "Nuradil" , "Nurbolat" , "Nurdaulet" , "Nurlan" , "Nursultan" , "Nurtileu" , "Olzhas" , "Rabbani" , "Raiymbek" , "Rakhat" ,
    "Ramazan" , "Ramilya" , "Rauan" , "Rollan" , "Rustem" , "Sabyr" , "Sagi" , "Saidgaffor" , "Saken" , "Salavat" , "Sandugash" , "Sanzhar" ,
    "Shapagat" , "Sherkhan" , "Shynggys" , "Shyngys" , "Tatyana" , "Temirlan" , "Temirzhan" , "Timur" , "Togzhan" , "Tomiris" , "Turgankhan" ,
    "Vladislav" , "Yeldos" , "Yerkali" , "Yerkhan" , "Yermek" , "Yernar" , "Yerzhan" , "Yussup" , "Zarina" , "Zhalgas" , "Zhanarys" , "Zhandos" ,
    "Zhangeldi" , "Zhannur" , "Zhansaya" , "Zhassulan" , "Zhibek" , "Zhuldyz"
  };
    
    public Student( Common common ) {
        super( common );
        this.common = common;
        grade = 0;
        
        int i = common.randomInt( 0, 99 );
        this.name = csci235StudentNames[ i ];
        
        state = common.randomStateStudent();
    }

    @Override
    public void draw( Graphics2D g2d ) {    
        Font fOriginal = g2d.getFont();
        FontMetrics fm = g2d.getFontMetrics();
        AffineTransform tOriginal = g2d.getTransform();
        String str;

        g2d.setFont( new Font( "Sans Serif", Font.BOLD, 14 ) );

        g2d.translate( ( int ) position.x, ( int ) position.y );
        
        if ( grade >= 100 )
            g2d.setPaint( Color.MAGENTA );
        else
            g2d.setPaint( Color.CYAN );

        g2d.fillOval( - 15, - 15, 30, 30 );

        g2d.setPaint( Color.BLACK );
        g2d.drawOval( - 15, - 15, 30, 30 );

        str = name;
        g2d.setPaint( Color.BLACK );
        g2d.drawString( str, ( int ) ( - fm.stringWidth( str ) / 2.0 ) - 7, - 18 );
        str = grade + "";
        g2d.setPaint( Color.BLACK );
        g2d.drawString( str, ( int ) ( - fm.stringWidth( str ) / 2.0 ) - 1, 6 );
        str = state.toString().split( "@" )[ 0 ];
        g2d.setPaint( Color.BLACK );
        g2d.drawString( str, ( int ) ( - fm.stringWidth( str ) / 2.0 ) - 7, 30 );

        g2d.setTransform( tOriginal );
        g2d.setFont ( fOriginal );
    }
    
    @Override
    public void step() {
        state.step( this );
    }
}
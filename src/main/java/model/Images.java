package model;

import javafx.scene.image.Image;

public class Images {
    public Image[] yellowBirdFly;
    public Image[] pinkBirdFly;
    public Image bulletImage;
    public Image[] bulletCollision;
    public Image[] shootEffect;
    public Image[] yellowBirdDeath;
    public Image[] pinkBirdDeath;
    public Image[] bossFly;
    public Image[] victory;
    public Image defeat;
    public Image[] bossShoot;
    public Image egg;
    public Image[] eggExplosion;
    public Image[] eggMove;
    public Image mute;
    public Image unmute;
    public Image[] hp;
    public Images(){
        pinkBirdFly = new Image[]{
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/purple/1.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/purple/2.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/purple/3.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/purple/4.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/purple/5.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/purple/6.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/purple/7.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/purple/8.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/purple/9.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/purple/10.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/purple/11.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/purple/12.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/purple/13.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/purple/14.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/purple/15.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/purple/16.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/purple/17.png"))),
        };
        yellowBirdFly = new Image[]{
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/yellow/1.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/yellow/2.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/yellow/3.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/yellow/4.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/yellow/5.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/yellow/6.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/yellow/7.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/yellow/8.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/yellow/9.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/yellow/10.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/yellow/11.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/yellow/12.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/yellow/13.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/yellow/14.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/yellow/15.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/yellow/16.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossFly/yellow/17.png"))),
        };
        bulletImage = new Image(String.valueOf(getClass().getResource("/Media/bullet.png")));
        bulletCollision = new Image[]{
                new Image(String.valueOf(getClass().getResource("/Media/Hit Dust/1.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Hit Dust/2.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Hit Dust/3.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Hit Dust/4.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Hit Dust/5.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Hit Dust/6.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Hit Dust/7.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Hit Dust/8.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Hit Dust/9.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Hit Dust/10.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Hit Dust/11.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Hit Dust/12.png"))),
        };
        shootEffect = new Image[]{
                new Image(String.valueOf(getClass().getResource("/Media/CupheadShoot/1.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/CupheadShoot/2.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/CupheadShoot/3.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/CupheadShoot/4.png"))),
                null,
        };
        yellowBirdDeath = new Image[]{
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossDeath/yellow/(1).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossDeath/yellow/(2).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossDeath/yellow/(3).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossDeath/yellow/(4).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossDeath/yellow/(5).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossDeath/yellow/(6).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossDeath/yellow/(7).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossDeath/yellow/(8).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossDeath/yellow/(9).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossDeath/yellow/(10).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossDeath/yellow/(11).png"))),
        };
        pinkBirdDeath = new Image[]{
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossDeath/pink/(1).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossDeath/pink/(2).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossDeath/pink/(3).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossDeath/pink/(4).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossDeath/pink/(5).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossDeath/pink/(6).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossDeath/pink/(7).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossDeath/pink/(8).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossDeath/pink/(9).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossDeath/pink/(10).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/MiniBossDeath/pink/(11).png"))),
        };
        bossFly = new Image[]{
                new Image(String.valueOf(getClass().getResource("/Media/BossFly/1.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/BossFly/2.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/BossFly/3.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/BossFly/4.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/BossFly/5.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/BossFly/6.png"))),
        };
        victory = new Image[]{
                new Image(String.valueOf(getClass().getResource("/Media/Victory/(1).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Victory/(2).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Victory/(3).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Victory/(4).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Victory/(5).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Victory/(6).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Victory/(7).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Victory/(8).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Victory/(9).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Victory/(10).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Victory/(11).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Victory/(12).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Victory/(13).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Victory/(14).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Victory/(15).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Victory/(16).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Victory/(17).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Victory/(18).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Victory/(19).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Victory/(20).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Victory/(21).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Victory/(22).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Victory/(23).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Victory/(24).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Victory/(25).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Victory/(26).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/Victory/(27).png"))),
        };
        defeat = new Image(String.valueOf(getClass().getResource("/Media/Defeat.jpeg")));
        bossShoot = new Image[] {
                new Image(String.valueOf(getClass().getResource("/Media/BossShoot/1.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/BossShoot/2.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/BossShoot/3.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/BossShoot/4.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/BossShoot/5.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/BossShoot/6.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/BossShoot/7.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/BossShoot/8.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/BossShoot/9.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/BossShoot/10.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/BossShoot/11.png"))),
                new Image(String.valueOf(getClass().getResource("/Media/BossShoot/12.png"))),
        };
        eggExplosion = new Image[]{
                new Image(String.valueOf(getClass().getResource("/Media/EggExplosion/(1).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggExplosion/(2).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggExplosion/(3).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggExplosion/(4).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggExplosion/(5).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggExplosion/(6).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggExplosion/(7).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggExplosion/(8).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggExplosion/(9).png"))),
        };
        eggMove = new Image[]{
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(1).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(2).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(3).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(4).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(5).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(6).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(7).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(8).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(9).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(10).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(11).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(12).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(13).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(14).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(15).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(16).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(17).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(18).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(19).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(20).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(21).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(22).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(23).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(24).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(25).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(26).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(27).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(28).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(29).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(30).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(31).png"))),
                new Image(String.valueOf(getClass().getResource("/Media/EggMove/(32).png"))),
        };
        mute = new Image(String.valueOf(getClass().getResource("/Media/mute.png")));
        unmute = new Image(String.valueOf(getClass().getResource("/Media/unmute.png")));
        hp = new Image[]{
                new Image(String.valueOf(getClass().getResource("/Media/Dead.jpeg"))),
                new Image(String.valueOf(getClass().getResource("/Media/hp1.jpeg"))),
                new Image(String.valueOf(getClass().getResource("/Media/hp2.jpeg"))),
                new Image(String.valueOf(getClass().getResource("/Media/hp3.jpeg"))),
                new Image(String.valueOf(getClass().getResource("/Media/hp4.jpeg"))),
                new Image(String.valueOf(getClass().getResource("/Media/hp5.jpeg"))),
                new Image(String.valueOf(getClass().getResource("/Media/hp6.jpeg"))),
                new Image(String.valueOf(getClass().getResource("/Media/hp7.jpeg"))),
                new Image(String.valueOf(getClass().getResource("/Media/hp8.jpeg"))),
        };
    }
}

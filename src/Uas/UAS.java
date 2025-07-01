package Uas;

import java.util.Scanner;

class Character {
    protected String nama;
    protected int hp;
    protected int fp; //focuspoint
    protected int stamina;
    protected int level;

    //constructor
    public Character(String nama, int hp, int fp, int stamina) {
        this.nama = nama;
        this.hp = hp;
        this.fp = fp;
        this.stamina = stamina;
        this.level = 1;
    }

    //accessors
    public int getHp() {return hp; }
    public int getFp() {return fp; }
    public int getStamina() {return stamina; }
    public int getLevel() {return level; }

    //mutators
    public void setHp(int hp) {
        this.hp = Math.max(hp, 0);
    }

    public void setFp(int fp) {
        this.fp = Math.max(fp, 0);
    }

    public void setStamina(int stamina) {
        this.stamina = Math.max(stamina, 0);
    }

    public void levelUp() {
        level++;
        System.out.println(nama + " naik ke level " + level + "!");
    }

    public void heal() {
        this.hp += 20;
        System.out.println(nama + " memulihkan HP. HP sekarang: " + this.hp);
    }

    public void showStatus() {
        System.out.println(nama + " | HP: " + hp + " | FP: " + fp + " | ST: " + stamina + " | Level: " + level);
    }

    //polymorphic
    public void attack(Enemy enemy) {
        System.out.println(nama + " menyerang musuh!");
        enemy.takeDamage(10); 
    }
}

//inheritance
class Warrior extends Character {
    public Warrior(String nama) {
        super(nama, 150, 40, 100);
    }

    @Override
    public void attack(Enemy enemy) {
        System.out.println(nama + " mengayunkan pedang besar! (-20 FP, -15 ST)");
        setFp(fp - 20);
        setStamina(stamina - 15);
        enemy.takeDamage(25);
    }
}

class Astrologer extends Character {
    public Astrologer(String nama) {
        super(nama, 90, 120, 60);
    }

    @Override
    public void attack(Enemy enemy) {
        System.out.println(nama + " menggunakan Glintstone Pebble! (-30 FP, -10 ST)");
        setFp(fp - 30);
        setStamina(stamina - 10);
        enemy.takeDamage(30);
    }
}

class Prisoner extends Character {
    public Prisoner(String nama) {
        super(nama, 110, 60, 80);
    }

    @Override
    public void attack(Enemy enemy) {
        System.out.println(nama + " menusuk dengan rapier cepat! (-15 FP, -20 ST)");
        setFp(fp - 15);
        setStamina(stamina - 20);
        enemy.takeDamage(20);
    }
}

class Enemy {
    private String nama;
    private int hp;

    public Enemy(String nama, int hp) {
        this.nama = nama;
        this.hp = hp;
    }
        //eoror handling menggunakan math.max untuk mencegah nilai negatif
        public void takeDamage(int damage) {
        hp = Math.max(hp - damage, 0);
        System.out.println(nama + " menerima " + damage + " damage. Sisa HP: " + hp);
    }

    public boolean isDefeated() {
        return hp <= 0;
    }

    public String getNama() {
        return nama;
    }

    public int getHp() {
        return hp;
    }
}

public class UAS {
    //io sederhana
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Character player = null;

        System.out.println("~A Tarnished of no renown. Cross the fog, to the Lands Between, to stand before the Elden Ring.\n" +
"And become the Elden Lord~");
        System.out.println("Pilih kelas karakter:");
        System.out.println("1. Warrior\n2. Astrologer\n3. Prisoner");
        
        int pilihan = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan nama karakter: ");
        String nama = scanner.nextLine();
        
        //seleksi
        switch (pilihan) {
            case 1:
                player = new Warrior(nama);
                break;
            case 2:
                player = new Astrologer(nama);
                break;
            case 3:
                player = new Prisoner(nama);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                return;
        }

        System.out.println("\nKarakter berhasil dibuat!");
        player.showStatus();

        //array musuh
        Enemy[] enemies = {
            new Enemy("Wanderer Nobles", 40),
            new Enemy("Godrick Soldier", 60),
            new Enemy("Troll", 100)
        };
        
        //perulangan
        for (Enemy enemy : enemies) {
            System.out.println("\nMusuh Muncul: " + enemy.getNama() + " ");
            while (!enemy.isDefeated()) {
                player.attack(enemy);
            }
            player.showStatus();
            player.levelUp();
        }

        System.out.println("\n---FIN---");
        player.showStatus();
    }
}

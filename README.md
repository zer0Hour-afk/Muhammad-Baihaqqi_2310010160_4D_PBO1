# Proyek Akhir Pemrograman Berbasis Objek 1

Proyek ini adalah kasus simulasi game Elden Ring menggunakan Java sederhana sebagai tugas akhir dari mata kuliah pemrograman berbasis objek 1.

## Deskripsi

Aplikasi ini adalah simulasi sederhana game Elden Ring yang dibuat menggunakan bahasa pemrograman Java. Dalam program ini, pengguna dapat memilih karakter (Warrior, Astrologer, atau Prisoner) dan melawan beberapa musuh seperti Wanderer Nobles, Godrick Soldier, dan Troll.

Aplikasi ini mengimplementasikan beberapa konsep penting dalam pemrograman berorientasi objek (OOP) seperti Class, Object, Atribut, Method Constructor, Method Mutator, Method Accessor, Encapsulation, Inheritance, Overloading, Overriding, Seleksi, Perulangan, IO Sederhana, Array, dan Error Handling.

## Penjelasan Kode

Berikut adalah bagian kode yang relevan dengan konsep OOP yang dijelaskan:

1. **Class** adalah template atau blueprint dari object. Pada kode ini, `UAS`, adalah contoh dari class.

```bash

public class UAS {
    ...
}
```

2. **Object** adalah instance dari class. Pada kode ini, `Enemy[] enemies = { new Enemy("Wanderer Nobles", 40),` adalah contoh pembuatan object.

```bash
Enemy[] enemies = { new Enemy("Wanderer Nobles", 40),
            ...
};
```

3. **Atribut** adalah variabel yang ada dalam class. Pada kode ini, `nama`, `hp`, `fp`, `stamina`, dan `level` adalah contoh atribut.

```bash
String nama;
int hp;
int fp;
int stamina;
int level;
```

4. **Constructor** adalah method yang pertama kali dijalankan pada saat pembuatan object. Pada kode ini, constructor ada di dalam class `Character`.

```bash
public Character(String nama, int hp, int fp, int stamina) {
        this.nama = nama;
        this.hp = hp;
        this.fp = fp;
        this.stamina = stamina;
        this.level = 1;
```

5. **Mutator** atau setter digunakan untuk mengubah nilai dari suatu atribut. Pada kode ini, `setHp` dan `setFp` adalah contoh method mutator.

```bash
 public void setHp(int hp) {
        this.hp = Math.max(hp, 0);
    }

    public void setFp(int fp) {
        this.fp = Math.max(fp, 0);
    }
```

6. **Accessor** atau getter digunakan untuk mengambil nilai dari suatu atribut. Pada kode ini, `getHp`, `getLevel`, `getFp`, dan `getStamina` adalah contoh method accessor.

```bash
 public int getHp() {return hp; }
```

7. **Encapsulation** adalah konsep menyembunyikan data dengan membuat atribut menjadi private dan hanya bisa diakses melalui method. Pada kode ini, atribut `nama` dan `hp` dienkapsulasi dan hanya bisa diakses melalui method getter dan setter.

```bash
protected String nama;
protected int hp;
```

8. **Inheritance** adalah konsep di mana sebuah class bisa mewarisi property dan method dari class lain. Pada kode ini, `Warior` mewarisi `Character` dengan sintaks `extends`.

```bash
class Warrior extends Character {
    ...
}
```

9. **Polymorphism** adalah konsep di mana sebuah nama dapat digunakan untuk merujuk ke beberapa tipe atau bentuk objek berbeda. Ini memungkinkan metode-metode dengan nama yang sama untuk berperilaku berbeda tergantung pada tipe objek yang mereka manipulasi, polymorphism bisa berbentuk Overloading ataupun Overriding. Pada kode ini, method `attack(Enemy enemy)` di class `Character` merupakan method yang dioverride oleh subclass `Warrior`, `Astrologer`, dan `Prisoner`. Masing-masing class memiliki gaya serangan dan konsumsi FP/Stamina yang berbeda.


```bash
@Override
    public void attack(Enemy enemy) {
        System.out.println(nama + " mengayunkan pedang besar! (-20 FP, -15 ST)");
        setFp(fp - 20);
        setStamina(stamina - 15);
        enemy.takeDamage(25);
    }
```

10. **Seleksi** adalah statement kontrol yang digunakan untuk membuat keputusan berdasarkan kondisi. Pada kode ini, digunakan seleksi seleksi `switch` dalam pi;ihan character.

```bash
switch (pilihan) {
            case 1:
                player = new Warrior(nama);
                break;
                .....
}
```

11. **Perulangan** adalah statement kontrol yang digunakan untuk menjalankan blok kode berulang kali. Pada kode ini, digunakan loop `for` untuk loop musuh dan loop `while` selama musuh belum kalah

```bash
for (Enemy enemy : enemies) {
            System.out.println("\nMusuh Muncul: " + enemy.getNama() + " ");
            while (!enemy.isDefeated()) {
                player.attack(enemy);
            }
```

12. **Input Output Sederhana** digunakan untuk menerima input dari user dan menampilkan output ke user. Pada kode ini, digunakan class `Scanner` untuk menerima input dan method `System.out.println` untuk menampilkan output.

```bash
Scanner scanner = new Scanner(System.in);
System.out.print("Masukkan nama karakter: ");
```

13. **Array** adalah struktur data yang digunakan untuk menyimpan beberapa nilai dalam satu variabel. Pada kode ini, `Enemy[] enemies` adalah contoh penggunaan array.

```bash
Enemy[] enemies = {
            new Enemy("Wanderer Nobles", 40),
            new Enemy("Godrick Soldier", 60),
            new Enemy("Troll", 100)
        };
```

14. **Error Handling** digunakan untuk menangani error yang mungkin terjadi saat runtime. Pada kode ini, digunakan `Math.max()` untuk mencegah mencegah nilai negatif.

```bash
public void takeDamage(int damage) {
        hp = Math.max(hp - damage, 0);
```

## Usulan nilai

| No  | Materi         |  Nilai  |
| :-: | -------------- | :-----: |
|  1  | Class          |    5    |
|  2  | Object         |    5    |
|  3  | Atribut        |    5    |
|  4  | Constructor    |    5    |
|  5  | Mutator        |    5    |
|  6  | Accessor       |    5    |
|  7  | Encapsulation  |    5    |
|  8  | Inheritance    |    5    |
|  9  | Polymorphism   |   10    |
| 10  | Seleksi        |    5    |
| 11  | Perulangan     |    5    |
| 12  | IO Sederhana   |   10    |
| 13  | Array          |   15    |
| 14  | Error Handling |   15    |
|     | **TOTAL**      | **100** |

## Pembuat

Nama: Muhammad Baihaqqi
NPM: 2310010160

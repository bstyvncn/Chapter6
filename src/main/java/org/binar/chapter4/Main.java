package org.binar.chapter4;

import org.binar.chapter4.model.*;
import org.binar.chapter4.repositories.userRepository;
import org.binar.chapter4.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;
@Service

public class Main {

    @Autowired
    IUsersService usersService;
    ISeatsService SeatsService;
    IScheduleService scheduleService;
    IFilmService filmService;
    IBookFilmService bookFilmService;

    static Scanner sc = new Scanner(System.in);
    static users users = new users();
    public static void init(Scanner args) {
        new Main();
    }

    public void Main() throws Exception {
        System.out.println("Input username = ");
        String username = sc.nextLine();

        System.out.println("Input password = ");
        String password = sc.nextLine();

        users.setUsername(username);
        users.setPassword(password);

        if (usersService.checkUsernameAndPassword(users) == false){
            mainMenu();
        }else{
            System.out.println("Akun tidak ditemukan!");
            regis();
        }
    }

    private void regis() {
        String username;

        String email;
        String address;
        String password;

        System.out.print("Username = ");
        username = sc.nextLine();
        System.out.print("Email = ");
        email = sc.nextLine();
        System.out.print("Address = ");
        address = sc.nextLine();
        System.out.print("Password = ");
        password = sc.nextLine();

        users.setUsername(username);
        users.setEmail(email);
        users.setAddress(address);
        users.setPassword(password);

        usersService.newUsers(users);
    }

    private void mainMenu() {
        System.out.println("1. Menampilkan film yang sedang tayang");
        System.out.println("2. Menampilkan jadwal film tertentu, studionya dan harga tiketnya");
        System.out.println("3. Menampilkan kursi yang masih tersedia");
        System.out.println("4. Melakukan reservasi tiket");
        System.out.print(">>");

        int input = sc.nextInt();
        sc.nextLine();

        switch (input){
            case 1:
                case1();
                break;

            case 2:
                case2();
                break;

            case 3:
                case3();
                break;

            case 4:
                case4();
                break;
        }
    }

    private void case4() {
//         4. Melakukan reservasi tiket
        System.out.print("Seats ID = ");
        int seatsID = sc.nextInt();
        seats seats = new seats();
        seats.setSeatsID(seatsID);

        System.out.print("Schedule ID = ");
        int scheduleID = sc.nextInt();

        schedule sch = new schedule();
        sch.setScheduleID(scheduleID);

        bookFilm bookFilm = new bookFilm();
        bookFilm.setSeats(seats);
        bookFilm.setSchedule(sch);

        bookFilmService.newBooking(bookFilm);

    }

    private void case3() {
//        3. Menampilkan kursi yang masih tersedia

        List<seats> s = SeatsService.showSeats();
        s.forEach(seats -> {
            System.out.println(seats.getStudioName());
            System.out.println(seats.getNomorKursi());
        });


    }

    private void case2() {
//        2. Menampilkan jadwal film tertentu, studionya dan harga tiketnya
        System.out.println("Input ID Film = ");
        System.out.print(">>");
        int id = sc.nextInt();

        film film = new film();
        film.setFilmID(id);
        List<schedule> sch = scheduleService.viewSchedule(film);

        sch.forEach(schedule -> {
            System.out.println(schedule.getScheduleID());
            System.out.println(schedule.getHargaTiket());
            System.out.println(schedule.getJamMulai());
            System.out.println(schedule.getJamSelesai());
            System.out.println(schedule.getNamaStudio());
        });
    }

    private void case1() {
//        1. Menampilkan film yang sedang tayang
        List<film> f = filmService.showFilm();
        f.forEach(film -> {
            System.out.println(film.getNamaFilm());
        });


    }
}

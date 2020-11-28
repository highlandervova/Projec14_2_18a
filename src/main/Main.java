package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Выбрать язык 1-En 2-Ukr");


        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        System.out.printf("Your input: %d \n", num);
        int x=0;


        switch (num) {
            case 1:
                Properties property = new Properties();
                try (FileInputStream fis = new FileInputStream("config.properties")) {
                    int i=-1;
                    while((i=fis.read())!=-1) {
//                    System.out.printf("File size: %d bytes \n", fin.available());
//                    int i=-1;
//                        System.out.print((char)i);


                        property.load(fis);
                        String c=property.getProperty("numbers");

                        System.out.println("numbers "+c);
                        x= Integer.parseInt (c);

                        for(int y=0;y<x;y++ ) {
                            String host = property.getProperty("dbhost"+y);
                            String login = property.getProperty("dblogin"+y);
                            String password = property.getProperty("dbpassword"+y);
                            System.out.println("HOST " + host + " Login " + login + " Password " + password);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }


                System.out.println("x = "+x );

                System.out.println("Введите host");

                Scanner str = new Scanner(System.in);
                String inputHost = in.next();

                inputHost="\n"+"dbhost"+x+"="+inputHost;

                //    System.out.printf("Your input: %d \n", inputHost);



                //nextLine(): считывает всю введенную строку
                //String text = "\n"+"Hello world!"; // строка для записи
                try (FileOutputStream fos = new FileOutputStream("config.properties", true)) {
                    // перевод строки в байты
                    byte[] buffer = inputHost.getBytes();

                    fos.write(buffer, 0, buffer.length);
                } catch (IOException ex) {

                    System.out.println(ex.getMessage());
                }
                System.out.println("The file has been written");


                System.out.println("Введите Login");
                Scanner str2 = new Scanner(System.in);
                String inputLogin = in.next();

                inputLogin="\n"+"dblogin"+x+"="+inputLogin;

                //    System.out.printf("Your input: %d \n", inputHost);



                //nextLine(): считывает всю введенную строку
                //String text = "\n"+"Hello world!"; // строка для записи
                try (FileOutputStream fos = new FileOutputStream("config.properties", true)) {
                    // перевод строки в байты
                    byte[] buffer = inputLogin.getBytes();

                    fos.write(buffer, 0, buffer.length);
                } catch (IOException ex) {

                    System.out.println(ex.getMessage());
                }
                System.out.println("The file has been written");


                System.out.println("Введите Passwd");
                Scanner str3 = new Scanner(System.in);
                String inputPsswd = in.next();

                inputPsswd="\n"+"dbpassword"+x+"="+inputPsswd;





                //nextLine(): считывает всю введенную строку
                //String text = "\n"+"Hello world!"; // строка для записи
                try (FileOutputStream fos = new FileOutputStream("config.properties", true)) {
                    // перевод строки в байты
                    byte[] buffer = inputPsswd.getBytes();

                    fos.write(buffer, 0, buffer.length);
                } catch (IOException ex) {

                    System.out.println(ex.getMessage());
                }
                System.out.println("The file has been written");

                x++;
                String inputNumbers="\n"+"numbers="+x;

                // найти размер файла
                //урезать файл  FileChannel.truncate (а размер последней строки)

                //или все пишим в ArrayList и наново пишем все данные потом в файл.
                // старый numbers  удаляем руками
                try (FileOutputStream fos = new FileOutputStream("config.properties", true)) {
                    // перевод строки в байты
                    byte[] buffer = inputNumbers.getBytes();

                    fos.write(buffer, 0, buffer.length);
                } catch (IOException ex) {

                    System.out.println(ex.getMessage());
                }
                System.out.println("The file has been written");



                in.close();


                break;
            case 2:
                System.out.println("create config.UKR");
                break;
        }
//        finally {
//            fis.close();
//        }

    }
}
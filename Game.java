import java.net.SocketOption;
import java.util.Scanner;
public class Game{
    private static int health = 7;
    private static int energy = 5;
    private static int magic = 3;
    private static int potions = 0;
    private static int runes = 0;
    private static boolean gameover = false;
    private static boolean gamewon = false;
    private static boolean Crystal = false;
    private static boolean map = false;
    private static boolean hiddenpath = false;

    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Привет, ты попал в игру Руны Судьбы");
        System.out.println("Давайте начнем игру");
        runGame();
    }
    private static void runGame(){
        while (!gamewon && !gameover){
            printStatus();
            System.out.println("Вы попали в некое измерение, выбирете локацию:");
            System.out.println("1.Лагерь");
            System.out.println("2.Лес");
            System.out.println("3.Алтарь");
            System.out.println("4.Финальный портал");
            System.out.println("Чтобы выйти из игры введите 5");
            int choise = Integer.parseInt(s.nextLine());
            if (choise==1){
                exploreCamp();
            }
            if (choise==2){
                exploreForest();
            }
            if (choise==3){
                inspectAltar();
            }
            if (choise==4){
                openFinalPortal();
            }
            if (choise==5){
                gameover = true;
                System.out.println("до новых встреч!!");
            }
            checkGameover();

        }
        if (gamewon){
            System.out.println("Вы выиграли игру, спасибо что провели время вместе в нами, до новых встреч!!");
        }else if (gameover){
            System.out.println("Вы решили покинуть игру, надеюсь вы еще вернетесь!!");
        }



    }
    private static void exploreCamp(){
       if (!map && !Crystal){
           System.out.println("Итак вы попали в лагерь вы можете выбрать, что хотите сделать:");
           System.out.println("1.Взять карту и изучить маршрут, это принесет вам +2 энергии и некие подсказки");
           System.out.println("2.Использовать кристалл, тогда вы сможете найти еще одну дорогу к руне");
           System.out.println("3.Вы можете исследовать лагерь, чтобы найти зелья, тогда вы теряете 1 энергию");
           int choise = Integer.parseInt(s.nextLine());
           if (choise==1){
               map = true;
               energy +=2;
               System.out.println("«На карте отмечены три возможных пути к первым рунам: один через густой лес, другой — по старой заброшенной дороге, третий — скрытая тропа, найденная рядом с лагерем».\n" +
                       "«Густой лес полон ловушек, но в нём есть полезные ресурсы. Старый путь безопасен, но долго обходить. Скрытая тропа — наиболее безопасна, но её сложно найти без магии».\n" +
                       "«Вижу, что на карте рядом с вами есть магический источник. Пройди его, если хочешь увеличить свои силы».\n");
           }
           if (choise==2){
               Crystal = true;
               hiddenpath = true;
               System.out.println("Вы нашли скрытую дорогу к первой руне");

           }
           if (choise==3){
               potions ++;
               energy --;
               System.out.println("Вы нашли зелье для восстановления жизни, при использовании вы восстанавливаете 5 жизней");
           }
       }
       else{
           System.out.println("Что вы хотите сделать?");
           System.out.println("1.Вы можете использовать зелье и восстановить 5 здоровья");
           if (map){
               System.out.println("2.Вы можете повторно исследовать карту");
           }else{
               System.out.print("2.Взять карту и изучить маршрут, это принесет вам +2 энергии и некие подсказки");

           }
           if (Crystal){
               System.out.println("3.Вы можете еще раз проскаинровать дорогу");
           }else {
               System.out.println("3.Используйте кристалл, чтобы найти скрытую дорогу");
           }
           System.out.println("4.Вы можете найти еще зелье");
           System.out.println("5.Покинуть лагерь");
           int choise = Integer.parseInt(s.nextLine());
           if (choise==1){
               if (potions >0){
                   Usepotions();
               }else{
                   System.out.println("У вас нет зельев, чтобы их использовать");
               }
           }
           if (choise==2){
               if (map){
                   System.out.println("Вы повторно исследовали карту, но она ничего нового вам не говорит и выводит: «На карте отмечены три возможных пути к первым рунам: один через густой лес, другой — по старой заброшенной дороге, третий — скрытая тропа, найденная рядом с лагерем».\\n\" +\n" +
                           "                       \"«Густой лес полон ловушек, но в нём есть полезные ресурсы. Старый путь безопасен, но долго обходить. Скрытая тропа — наиболее безопасна, но её сложно найти без магии».\\n\" +\n" +
                           "                       \"«Вижу, что на карте рядом с вами есть магический источник. Пройди его, если хочешь увеличить свои силы».\\n\"");
               }else{
                   map = true;
                   energy +=2;
                   System.out.print("«На карте отмечены три возможных пути к первым рунам: один через густой лес, другой — по старой заброшенной дороге, третий — скрытая тропа, найденная рядом с лагерем».\n" +
                           "«Густой лес полон ловушек, но в нём есть полезные ресурсы. Старый путь безопасен, но долго обходить. Скрытая тропа — наиболее безопасна, но её сложно найти без магии».\n" +
                           "«Вижу, что на карте рядом с вами есть магический источник. Пройди его, если хочешь увеличить свои силы».\n");
               }
           }
           if (choise==3){
               if (Crystal) {
                   System.out.println("Вы повторно использовали крисстал, и он говорит, что скрытая дорога все еще тут");
               }else{
                   Crystal = true;
                   hiddenpath = true;
                   System.out.println("Вы нашли скрытую дорогу к первой руне");

               }
           }
           if (choise==4){
               potions ++;
               energy --;
               System.out.println("Вы нашли еще одно зелье, теперь у вас их больше");
           }
           if (choise==5){
               runGame();
           }
       }



    }
    private static void exploreForest(){
        System.out.println("Вы попали в лес, добро пожаловать,каждое ваше решение влияет на ресурсы, будьте внимательны хватит ли вам ресурсов для преодоления пути");
        System.out.println("Выберите по какому пути желаете пойти:");
        System.out.println("1.Пойти по густому лесу, но чтобы пройти у вас должно быть не менее 3 здоровья и 2 энергии");
        System.out.println("2.Вызвать магического фамильяра для разведки пути, чтобы все получилось у вас должно быть не менее 2 магии");
        if (hiddenpath){
            System.out.println("3.Так как при обследовании лагеря вы нашли скрытую дорогу, то можете пройти через нее");
        }
        System.out.println("4.Вернуться в лагерь");
        int choise = Integer.parseInt(s.nextLine());
        if (choise==1){
            if (health>=3 && energy>=2){
                System.out.println(" «Вы уверенно идёте по основному пути, избегая некоторых ловушек, но несколько всё-таки срабатывают. К счастью, вы не получили серьёзных травм, и ваш путь продолжается».\n" +
                        "\n" +
                        "После прохождения через густой лес герой теряет 3 здоровья, но находит магический амулет и получает +2 к энергии.");
                health -=3;
                energy +=2;
            }
            else {
                health -=5;
                energy -=2;
                System.out.println("«Вы не успеваете избежать всех ловушек, и несколько из них активируются. Вам удаётся выбраться, но ваши силы на исходе».");
            }
        }
        if (choise==2){
            if (magic>=2){
                magic -=2;
                health +=3;
                System.out.println("«Вы вызываете своего фамильяра, и он, используя свои способности, находит безопасный путь через лес, избегая большинства опасностей,при этом вы тратите 2 магии, но восстанавливаете 3 здоровья»");
            }else{
                magic -=2;
                energy -=2;
                System.out.println("«Магия фамильяра не срабатывает должным образом, и вы теряете силы, не получив нужной помощи».\n");

            }

        }
        if (hiddenpath){
            if (choise==3){
                if (magic>=2){
                    energy +=2;
                    System.out.println(" «Вы выбрали скрытую тропу, и, благодаря подсказкам на карте, смогли избежать ловушек и не потерять много сил».");
                }else {
                    magic -=3;
                    health -=1;
                    System.out.println(" «Скрытая тропа оказывается полна неожиданных магических ловушек. Вы теряете драгоценную энергию, пытаясь от них защититься».");
                }
            }
        }
        if (choise==4){
            exploreCamp();
        }




    }
    private static void inspectAltar(){
        System.out.println("После того как вы исследрвали лес, вы находите древний алтарь, который охраняет руну");
        System.out.println("ПОДСКАЗКА: ЕСЛИ ВЫ ЕЩЕ НЕ ОБСЛЕДОВАЛИ ЛЕС, ТО ВЕЕРНИТЕСЬ ТУДА, ЧТОБЫ ТУДА ВЕРНУТЬСЯ ВВЕДИТЕ 0, ЧТОБЫ ПРОДОЛЖИТЬ ВВЕДИТЕ 1");
        int choise1 = Integer.parseInt(s.nextLine());
        if (choise1==0){
            exploreForest();
        }
        if (choise1==1){
            System.out.println("Итак, вы нашли алтарь выберите, что хотите сделать:");
            System.out.println("1.Исследовать символы на алтаре, чтобы успешно исследовать у вас должно быть не менее 3 энергий и 1 магии, иначе вы теряете 3 здоровья");
            if (Crystal){
                System.out.println("2.Использовать магический кристалл, найденный ранее, чтобы его использовать у вас должно быть не менее 2 энергий, иначе вы теряете 1 энергию и 1 здоровье");
            }
            System.out.println("3.Попытаться разрушить алтарь, чтобы его разрушить у вас должно быть хотя бы 3 здоровья и 3 магии");
            int choise = Integer.parseInt(s.nextLine());
            if (choise==1){
                if (energy>=3 && magic>=1){
                    System.out.println("«Вы внимательно изучаете символы и, приложив усилия, расшифровываете их значение. Это открывает секретный механизм и позволяет вам получить первую руну без лишних трудностей, и получаете 2 энергии и 1 магию»");
                    energy +=2;
                    magic+=1;
                }else {
                    System.out.println(" «Ваши попытки расшифровать символы не приводят к успеху. Алтарь выбрасывает магический импульс, и вы теряете несколько сил»");
                    health -=3;
                }
            }
            if (choise==2){
                if (Crystal){
                    if (energy>=2){
                        System.out.println("«Вы активируете кристалл, и его свет облучает алтарь. Он указывает путь к руне, и вы успеваете пройти к ней без потерь».");
                        health+=3;
                        energy-=2;
                    }else {
                        energy --;
                        health --;
                        System.out.println("«Когда вы активировали кристалл, его энергия не совпала с энергией алтаря, что привело к небольшому откату магии. Портал остаётся заблокированным».\n");

                    }
                }else{
                    System.out.println("У вас не кристалла");
                }
            }
            if (choise == 3){
                if (health>=3 && magic>=3){
                    System.out.println("«Вы решаете разрушить алтарь и, используя свою магическую мощь, разрушаете его. Это даёт вам доступ к первой руне».");
                    health-=5;
                    runes ++;

                }else{
                    energy -=3;
                    System.out.println(" «Ваши попытки разрушить алтарь не увенчались успехом. Алтарь выбрасывает мощный магический импульс, отбрасывая вас назад».");
                }
            }

        }


    }
    private static void openFinalPortal(){
        System.out.println("Вы попали в последнюю локацию нашей игры, чтобы выиграть вам требуется активировать портал и пройти через него, вы думаете это будет так просто? Вы ошибаетесь!");
        System.out.println("Чтобы активировать портал, у вас должно быть: 1 руна, не менее 5 здоровья, 3 энегрии и 1 магии, иначе вернитесь на прошлые локации, чтобы повысить количесвто ресурсов");
        System.out.println("Выберите что ходите сделать:");
        System.out.println("1.Активировать портал");
        System.out.println("2.Вернуться в предыдущие локации,чтобы повысить ресурсы");
        int choise = Integer.parseInt(s.nextLine());
        if (choise ==1){
            if (runes>=1 && health>=5 && energy>=3 && magic>=1){
                System.out.println("Поздравляю вы прошли нашу игру, вы проявили смелость и отвагу, не побоялись трудных препятсвтвий!!!");
                System.out.println("Надеюсь,вы посоветуюте нашу игру всем своим друзьям!!");
                gamewon = true;
            }
        }
        if (choise ==2){
            runGame();
        }

        
    }
    private static void Usepotions(){
        potions --;
        health +=5;

    }
    private static void checkGameover(){
        if (health<=0){
            if (potions>0){
                System.out.println("У вас остались зелья, поэтому мы их используем");
                Usepotions();
            }else{
                System.out.println("У вас не осталось зельев, вы проиграли.....");
                gameover = true;

            }
        }
        if (energy<=0){
            System.out.println("Вы проиграли эх");
            gameover = true;
        }


    }
    private static void printStatus(){
        System.out.println("\n--- Your Status ---");
        System.out.println("Health: " + health);
        System.out.println("Energy: " + energy);
        System.out.println("Magic: " + magic);
        System.out.println("Potions: " + potions);
        System.out.println("Runes: " + runes);
    }
}
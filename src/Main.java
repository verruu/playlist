import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<Album> albums = new ArrayList<>();

        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("Holy man", 4.3);
        album.addSong("Hold on", 5.6);
        album.addSong("Lady double dealer", 3.21);
        album.addSong("You can't do it right", 6.23);
        album.addSong("High ball shooter", 4.27);
        album.addSong("The gypsy", 4.2);
        album.addSong("Soldier of fortune", 3.13);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("I put the finger on you", 3.25);
        album.addSong("Lets go", 3.45);
        album.addSong("Inject the venom", 3.33);
        album.addSong("Snowballed", 4.51);
        album.addSong("Evil walks", 3.45);
        album.addSong("C.O.D.", 5.25);
        album.addSong("Breaking the rules", 5.32);
        album.addSong("Night of the long knives", 5.12);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("You can't do it right", playList);
        albums.get(0).addToPlayList("Holy man", playList);
        albums.get(0).addToPlayList("Speed king", playList);  // Does not exist
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(24, playList);  // There is no track 24
        playPlayList(playList);
//        albumsList(albums);
//        songList(albums);
    }

//    public static void albumsList(ArrayList<Album> albums) {
//        for (int i = 0; i < albums.size(); i++) {
//            System.out.println("Album name: " + albums.get(i).getName());
//        }
//    }
//
//    public static void songList(ArrayList<Album> albums) {
//        for (int i = 0; i < albums.size(); i++) {
//            Album album = albums.get(i);
//
//            for (int j = 0; j < album.songs.size(); j++) {
//                String songName = album.songs.get(j).getTitle();
//                System.out.println("Song name: " + songName);
//            }
//        }
//    }
    public static void playPlayList(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.size() == 0) {
            System.out.println("There are no songs in your playlist.");
            return;
        } else System.out.println("Now playing: " + listIterator.next().toString());
        printMenu();

        while (!quit) {
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0:
                    System.out.println("Playlist stopped.");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) listIterator.next();
                        forward = true;
                    }
                    if (listIterator.hasNext())
                        System.out.println("Now playing: " + listIterator.next().toString());
                    else {
                        System.out.println("End of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) listIterator.previous();
                        forward = false;
                    }
                    if (listIterator.hasPrevious())
                        System.out.println("Now playing: " + listIterator.previous().toString());
                    else {
                        System.out.println("Beginning of the playlist.");
                        forward = true;
                    }
                    break;
                case 3:
//                    ReplayCurrent();
                    break;
                case 4:
                    printSongList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                default:
                    System.out.println("Invalid input, please try again (0 to quit, 5 for menu).");
                    break;
            }
        }
    }

    public static void printSongList(LinkedList<Song> playList) {
        for (int i = 0; i < playList.size(); i++)
            System.out.println(playList.get(i).toString());
//        TIM'S POINT OF VIEW
//        Iterator<Song> iterator = playList.iterator();
//        System.out.println("============================");
//        while (iterator.hasNext())
//            System.out.println(iterator.next());
//        System.out.println("============================");
    }

    public static void printMenu() {
        System.out.println("Playlist menu\n" +
                "Press: \n" +
                "0 to exit the playlist,\n" +
                "1 to move to the next song,\n" +
                "2 to move to the previous song,\n" +
                "3 to replay the current song,\n" +
                "4 to print full song list,\n" +
                "5 to print the playlist menu");
    }
}

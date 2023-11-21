package foster.terry.aoc2022;

import java.util.*;

public class Day07 {
    final private String id;
    final private String name;
    private int size;
    final private List<Day07> contents;
    final private String parent;
    final private boolean isFolder;
    private Map<String, Integer> directorySizes;

    public Day07(final List<String> input) {
        this.id = UUID.randomUUID().toString();
        this.name = "/";
        this.size = 0;
        this.contents = new ArrayList<>();
        this.parent = "";
        this.isFolder = true;
        directorySizes = new Hashtable<>();

        Day07 currentDirectory = this;
        //Process through input
        for(int x = 1; x < input.size(); x++) {
            String line = input.get(x);
            if (line.contains("$")) {
                if (line.contains("..")) {
                    //move up a directory

                    //find parent directory node
                    currentDirectory = findParent(this, currentDirectory == null ? "" : currentDirectory.parent);
                    if (currentDirectory != null) { updateFolderSize(currentDirectory); }
                }
                else if (line.contains("$ cd")) {
                    //move into a directory

                    if (currentDirectory != null) {
                        updateFolderSize(currentDirectory);

                        //find directory node
                        String folder = line.split(" ")[2];
                        currentDirectory = moveInto(currentDirectory, folder);
                    }

                }

            }
            else {
                //Add files/folders to current folder

                boolean _isFolder = true;
                String[] file = line.split(" ");
                int size = 0;
                if (!file[0].contains("dir")) {
                    _isFolder = false;
                    size = Integer.parseInt(file[0]);
                }

                if (currentDirectory != null) {
                    currentDirectory.addchild(new Day07(UUID.randomUUID().toString(), file[1], size, currentDirectory.id, _isFolder));
                    updateFolderSize(currentDirectory);
                }
            }
        }
        updateFolderSize(this);
    }
    public Day07(final String id, final String name, final int size, final String parent, final boolean isFolder) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.parent = parent;
        this.isFolder = isFolder;
        this.contents = new LinkedList<>();
    }

    public void addchild(final Day07 childNode) {
        this.contents.add(childNode);
    }

    private Day07 moveInto(final Day07 currentDirectory, final String name)
    {
        for (Day07 folder : currentDirectory.contents) {
            if (folder.name.equals(name) && folder.isFolder) {
                return folder;
            }
        }
        return null;

    }
    private Day07 findParent(final Day07 currentDirectory, final String id) {
        if (currentDirectory.id.equals(id) && currentDirectory.isFolder) {
            return currentDirectory;
        }
        for (Day07 folder : currentDirectory.contents.stream().filter(i -> i.isFolder).toList()) {
            if (folder.id.equals(id)) {
                return folder;
            }
            else {
                Day07 found = findParent(folder, id);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }

    private void updateFolderSize(Day07 folder) {
        folder.size = 0;
        for (Day07 item : folder.contents) {
            folder.size += item.size;
        }

        directorySizes.put(folder.id, folder.size);

    }

    public int getTotalSizeUnder(int underSize) {
        return directorySizes.values()
                .stream()
                .filter(integer -> integer < underSize)
                .mapToInt(integer -> integer).sum();

    }

    public int freeUpSizeMin(int size) {

        int freeSpace = 70000000 - directorySizes.values()
                .stream()
                .sorted(Comparator.reverseOrder())
                .mapToInt(integer -> integer).toArray()[0];

        return directorySizes.values()
                .stream()
                .sorted()
                .filter(integer -> integer >= size-freeSpace)
                .mapToInt(integer -> integer).toArray()[0];
    }



}

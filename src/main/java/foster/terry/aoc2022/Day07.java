package foster.terry.aoc2022;

import java.util.*;

public class Day07 {
    private final Directory files = new Directory("/", 0, "", true);
    private final Map<String, Integer> directorySizes = new HashMap<>();

    public Day07(final List<String> input) {
        Directory currentDirectory = files;
        //Process through input
        for(int x = 1; x < input.size(); x++) {
            String line = input.get(x);
            if (line.contains("$")) {
                if (line.contains("..")) {
                    //move up a directory

                    //find parent directory node
                    currentDirectory = files.findParent(currentDirectory == null ? "" : currentDirectory.parent);
                    if (currentDirectory != null) { currentDirectory.updateFolderSize(); }
                }
                else if (line.contains("$ cd")) {
                    //move into a directory

                    if (currentDirectory != null) {
                        currentDirectory.updateFolderSize();

                        //find directory node
                        String folder = line.split(" ")[2];
                        currentDirectory = currentDirectory.moveInto(folder);
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
                    currentDirectory.addchild(new Directory(file[1], size, currentDirectory.id, _isFolder));
                    currentDirectory.updateFolderSize();
                }
            }
        }
        files.updateFolderSize();
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

    class Directory {
        final String id;
        final String name;
        private int size;
        final List<Directory> contents;
        final String parent;
        final boolean isFolder;

        Directory(String name, int size, String parent, boolean isFolder) {
            this.id = UUID.randomUUID().toString();
            this.name = name;
            this.size = size;
            this.parent = parent;
            this.isFolder = isFolder;
            this.contents = new ArrayList<>();
        }
        public void addchild(final Directory childNode) {
            this.contents.add(childNode);
        }

        private Directory findParent(final String id) {
            if (this.id.equals(id) && this.isFolder) {
                return files;
            }
            for (Directory folder : this.contents.stream().filter(i -> i.isFolder).toList()) {
                if (folder.id.equals(id)) {
                    return folder;
                }
                else {
                    Directory found = folder.findParent(id);
                    if (found != null) {
                        return found;
                    }
                }
            }
            return null;
        }
        private Directory moveInto(final String name) {
            for (Directory folder : this.contents.stream().filter(i -> i.isFolder).toList()) {
                if (folder.name.equals(name)) {
                    return folder;
                }
            }
            return null;
        }

        private void updateFolderSize() {
            this.size = 0;
            for (Directory item : this.contents) {
                this.size += item.size;
            }

            directorySizes.put(this.id, this.size);

        }

    }


}

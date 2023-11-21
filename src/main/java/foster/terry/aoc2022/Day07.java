package foster.terry.aoc2022;

import java.util.*;

public class Day07 {
    private final Directory files = new Directory("/", 0, null, true);
    private final Map<String, Integer> directorySizes = new HashMap<>();

    public Day07(final List<String> input) {
        Directory currentDirectory = files;
        //Process through input
        for(final String line : input) {
            if (line.contains("$")) {
                //move up a directory
                if (line.contains("..")) {
                    if (currentDirectory != null) { currentDirectory = currentDirectory.getParent(); }
                }
                //move into a directory
                else if (line.contains("$ cd")) {
                    String folder = line.split(" ")[2];
                    if (currentDirectory != null) { currentDirectory = currentDirectory.moveInto(folder); }
                }
            }
            else {
                //Add files/folders to current folder
                if (currentDirectory != null) { currentDirectory.addChild(line); }
            }
        }
        files.updateFolderSize();
    }
    public int getTotalSizeUnder(final int underSize) {
        return files.getSubdirectorySizes()
                .stream()
                .filter(integer -> integer < underSize)
                .mapToInt(integer -> integer).sum();
    }

    public int freeUpSizeMin(final int sizeNeeded) {

        int freeSpace = 70000000 - directorySizes.values()
                .stream()
                .sorted(Comparator.reverseOrder())
                .mapToInt(integer -> integer).toArray()[0];

        return files.getSubdirectorySizes()
                .stream()
                .sorted()
                .filter(integer -> integer >= sizeNeeded-freeSpace)
                .mapToInt(integer -> integer).toArray()[0];
    }

    class Directory {
        final String id;
        final String name;
        private int size;
        final List<Directory> contents;
        final Directory parent;
        final boolean isFolder;

        Directory(final String name, final int size, final Directory parent, final boolean isFolder) {
            this.id = UUID.randomUUID().toString();
            this.name = name;
            this.size = size;
            this.parent = parent;
            this.isFolder = isFolder;
            this.contents = new ArrayList<>();
        }
        public void addChild(String line) {
            boolean _isFolder = true;
            String[] file = line.split(" ");
            int size = 0;
            if (!file[0].contains("dir")) {
                _isFolder = false;
                size = Integer.parseInt(file[0]);
            }
            this.contents.add(new Directory(file[1], size, this, _isFolder));
            this.updateFolderSize();
        }

        private Directory getParent() {
            parent.updateFolderSize();
            return parent;
        }
        private Directory moveInto(final String name) {
            this.updateFolderSize();
            if (name.equals("/")) { return files; }
            for (final Directory folder : this.contents.stream().filter(i -> i.isFolder).toList()) {
                if (folder.name.equals(name)) {
                    return folder;
                }
            }
            return null;
        }

        private void updateFolderSize() {
            this.size = 0;
            for (final Directory item : this.contents) {
                this.size += item.size;
            }

            directorySizes.put(this.id, this.size);

        }

        public int getSize() {
            this.size = 0;
            for (final Directory child : contents.stream().filter(x -> x.isFolder).toList()) {
                this.size += child.getSize();
            }
            for (final Directory child : contents.stream().filter(x -> !x.isFolder).toList()) {
                this.size += child.size;
            }
            return size;
        }

        public List<Integer> getSubdirectorySizes() {
            final List<Integer> sizes = new ArrayList<>();
            for (final Directory child : contents.stream().filter(x -> x.isFolder).toList()) {
                sizes.addAll(child.getSubdirectorySizes());
                sizes.add(child.getSize());
            }
            return sizes;
        }

    }


}

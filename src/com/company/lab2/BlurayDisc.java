package com.company.lab2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BlurayDisc {

    public Directory disc = new Directory("root");

    public BlurayDisc(Directory disc) {
        this.disc = disc;
    }

    public BlurayDisc() {
    }

    class Directory {
        String name;

        public Directory(String name) {
            this.name = name;
        }

        HashSet<Directory> dirs = new HashSet<>();
        HashSet<File> files = new HashSet<>();

    }
    class File {
            String name, extension;

        public File() {
        }

        public File(String name, String extension) {
            this.name = name;
            this.extension = extension;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getExtension() {
            return extension;
        }

        public void setExtension(String extension) {
            this.extension = extension;
        }
    }

}

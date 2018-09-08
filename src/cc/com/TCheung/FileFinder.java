package cc.com.TCheung;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;

public class FileFinder extends SimpleFileVisitor<Path> {
    private final PathMatcher matcher;
    private List<Path> matchedPaths = new ArrayList<Path>();

    FileFinder(String pattern)
    {
        matcher = FileSystems.getDefault().getPathMatcher("glob:"+ pattern);
    }

    void match(Path file)
    {
        Path name = file.getFileName();
        if(name!=null && matcher.matches(name)){
            matchedPaths.add(name);
        }
    }
    @Override
    public FileVisitResult visitFile(Path file,BasicFileAttributes attrs)
    {
        match(file);
        return  CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
    {
        match(dir);
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc)
    {
        System.err.println(exc);
        return  CONTINUE;
    }
    public int getTotalMatches()
    {
        return matchedPaths.size();
    }
    public Collection<Path> getMatchedPaths()
    {
        return matchedPaths;
    }
}


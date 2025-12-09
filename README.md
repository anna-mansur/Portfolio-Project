# Portfolio Project -- Playlist Component

## Component Overview

This project implements a Playlist component that follows the OSU components design pattern.

### Structure

- Kernel Interface -> PlaylistKernel
- Enhanced Interface -> Playlist
- Abstract Class -> PlaylistSecondary
- Kernel Implementation -> PlaylistOnQueue

## Purpose

This Playlist component models a music playlist that behaves similarly to the OSU queue component.

### Functions

- Adding songs to playlist
- Removing the current song
- Skipping the current song
- Finding information about current song
- Checking if song is included in the playlist
- Listing all songs
- Shuffling songs

A Song is represented with a Java record:

```java
public static record Song(String title, String artist) { }
```

## Examples and Testing

Two example use files are included in src to demonstrate the functions of the component. Test files for the abstract and kernel class are included as well.

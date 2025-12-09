# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## [2025.12.6]

### Added

- Designed test suite for Playlist component
- Designed two different use cases for Playlist component
- Docs folder of html files for Java documentation

### Updated

- Updated the directory structure so it can be bundled as a .jar

## [2025.11.19]

### Added

- Designed kernel implementation for Playlist component

### Updated

- Changed design to include updating equals() method in PlaylistSecondary to check for object equaling null or this

## [2025.11.6]

### Added

- Designed abstract class for Playlist component

## [2025.10.20]

### Added

- Designed kernel and enhanced interfaces for Playlist component

### Updated

- Changed design to include use of Song record instead of generic Pair<K, V>
- Added hasSong(), currentArtist(), and currentTitle() secondary methods

## [2025.10.10]

### Added

- Designed a proof of concept for Playlist component

### Updated

- Changed design to include adding playlistSize() kernel method and listAll() secondary method.

## [2025.09.15]

### Added

- Designed a Bookshelf component
- Designed a Playlist component
- Designed a Movie component

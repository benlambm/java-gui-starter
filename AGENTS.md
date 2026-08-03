# AGENTS.md

## Warning: Student Repo

The student must steer this repo. You assist; they decide. They are
learning Java — if you write the TODO method bodies for them, you have
wasted their tuition. Explain, point at the failing test, suggest the
next experiment — do not hand over finished implementations.

## What this is

A small Java 21 Swing game for learning inheritance and the strategy
pattern: animals cross a window, the player clicks to hunt them with a
swappable instrument (Bow / Camera).

```
src/  is source (model + gui + Main)     test/  is unit tests
lib/  is jars                            bin/   is compiled output
```

Package `edu.vwcc.itp220mod3.model` is pure Java — it must NEVER import
Swing or AWT. Package `edu.vwcc.itp220mod3.gui` is the provided window;
`Main` stays in the default package.

## Don't touch

`.project`, `.classpath`, `.settings/`, `.gitignore`, `.gitattributes`.
These make the folder open correctly in Eclipse, VS Code, and Cursor
alike. The tests in `test/` are the assignment spec — never edit a test
to make it pass.

## Code style

Java 21, four spaces. This module deliberately introduces the strategy
pattern (one interface, swappable implementations) and lambdas for GUI
event listeners — those stay. Everything else stays beginner-legible:
no streams, no clever one-liners; loops are the house style. Model
logic stays out of the GUI so it can be tested. Comments explain *why*.

## Before you claim it works, run it

One line — this must paste into PowerShell, Command Prompt, and a macOS
terminal unchanged, so no backslash continuations.

```
java -jar lib/junit-platform-console-standalone-1.14.4.jar execute --class-path bin --scan-class-path --details=tree
```

The GUI wiring TODO has no test: verify it by launching `Main`,
switching to Camera, and shooting an animal — it must fade, not vanish.

Never commit, push, or create branches unless asked.

# Java GUI Starter: Swing Safari Game

Module 3 of the same series as
[java-git-starter](https://github.com/benlambm/java-git-starter) and
[java-oop-starter](https://github.com/benlambm/java-oop-starter). Same
tooling, same workflow — but this time your object model has a **game
window on top of it**: animals cross the screen, you click to hunt them,
and every piece of Module 2 theory (inheritance, interfaces,
polymorphism) becomes something you can literally watch.

## What you need

- **Git**
- **JDK 21 or newer** (Temurin / Adoptium is the usual free build)
- One of:
  - Eclipse IDE for Java Developers (2025-09 or newer)
  - VS Code or Cursor, with the recommended **Extension Pack for Java**

Setup is identical to the first two modules — if those projects open on
your machine, this one will too. Clone URL:

```text
https://github.com/benlambm/java-gui-starter.git
```

Clone it from inside a terminal CLI first, then open in Eclipse **File →
Open Projects from File System…**.

## Run it FIRST

`src/Main.java` launches the game. Run it before you write anything.

The window opens and the field is **frozen**: five animals stand still,
clicks do nothing, the instrument corner is blank. Every TODO you finish thaws
it a little and by the last one you're playing a working game you
built. Re-run it after every green test class.

## The model

| Class | What it is | The idea it teaches |
| --- | --- | --- |
| `Animal` | Abstract base: position, speed, hit circle | **Inheritance** — shared code written once |
| `Deer` | Walks right, 10 pts — **finished, your worked example** | What a subclass owes its parent |
| `Duck` | Flies right and *bobs*, 25 pts | Overriding with real math |
| `Bear` | Lumbers *left*, 50 pts | Same contract, opposite behavior |
| `ShootBehavior` | What a trigger-pull means | **Interface as STRATEGY** |
| `Bow` | Harvest: full points, animal removed | One strategy |
| `Camera` | Photograph: double points, animal spared (once!) | Another — with state |
| `ShotResult` | What one shot did | **Record** (Module 2 callback) |
| `Hunter` | Holds the current strategy | The **context** — delegation, no ifs |
| `Game` | Animals + hunter + score | Where hierarchy meets strategy |

And a second package, `edu.vwcc.itp220mod3.gui` = the Swing window.
It is **provided**: read it, run it, wire up 1 button in it, but the
model is where you code. Notice the boundary: the `model` package never
imports Swing, which is how the tests can play the game without
opening a window.

## Run the tests

The `test/` folder holds **28 tests** across eight files. On a fresh
clone **6 are green** — `Animal`'s hit circle and the finished `Deer`
are your compass — and **22 fail**. Each failing test is one to-do
item, and the tests are the precise version of the instructions.

- **Eclipse:** right-click the `test` folder, or a single test file →
  **Run As → JUnit Test**
- **VS Code / Cursor:** click the beaker icon in the left sidebar, or
  the arrow in the gutter next to a test method
- **Any terminal:**

```text
java -jar lib/junit-platform-console-standalone-1.14.4.jar execute --class-path bin --scan-class-path --details=tree
```

## The exercises

15 TODOs in the model plus one gui button. Every one sits under an
`Instructions:` comment that says exactly what it must do. Suggested
route, easiest to hardest:

| Step | Where | What you implement |
| --- | --- | --- |
| 1 | `Duck`, `Bear` | `move()` and `getPoints()` — **study `Deer` first** |
| 2 | `Bow` | `name()`, `soundEffect()`, `shoot()` — three tiny wins |
| 3 | `Camera` | Same three, plus the camera-shy state |
| 4 | `Hunter` | Pure delegation — the strategy pattern's engine room |
| 5 | `Game` | `update()` and `shoot()` — everything meets here |
| 6 | `GameFrame` | Wire the Camera button (no test — the proof is on screen) |

Order matters: `HunterTest` fires the default `Bow`, so Bow must work
before Hunter can pass, and `GameTest` uses both strategies through the
hunter. 

### How to work through them

1. **Run the game, then the tests.** Frozen window, 22 red — that is
   the correct start.
2. **Pick the next class on the route.** Read its `Instructions:`
   comment, then open its test file and read the exact values expected.
3. **Write the method bodies.**
4. **Re-run just that one test class** until it is green — then run
   the game and see what changed on screen.
5. **Commit.** One green test class is a perfect-sized commit with an
   obvious message.

## Complete the starter — 70 points

Get all **28 provided tests** passing. This requirement is worth 70
points. Run `Main` and confirm that the game launches and is playable
before you begin your enhancements.

## Add three feature enhancements — 30 points

Add **three distinct, working improvements** to the game. Each
enhancement is worth 10 points and must leave all 28 provided tests
passing.

Possible enhancements include:

- a new animal with its own movement
- a new hunting instrument
- a game-over and restart flow
- new or randomly respawning animals
- a new game mode or scoring rule
- improved animal graphics

Choose any three. You may also propose your own improvements. Unit
tests for your enhancements are recommended, but they are not required
and will not be used for grading.

## Before you submit

- `Main` launches and the game is playable.
- All 28 provided tests pass.
- Three feature enhancements work in the running game.
- All provided tests still pass after the enhancements.
- Submit the completed project through the Canvas assignment.

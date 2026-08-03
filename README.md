# Java GUI Starter

Module 3 of the same series as
[java-git-starter](https://github.com/benlambm/java-git-starter) and
[java-oop-starter](https://github.com/benlambm/java-oop-starter). Same
tooling, same workflow — but this time your object model has a **game
window on top of it**: animals cross the screen, you click to hunt them,
and every piece of Module 2 theory (inheritance, interfaces,
polymorphism) becomes something you can literally watch.

Two big ideas share top billing:

- an **inheritance hierarchy** that moves: `Deer`, `Duck`, and `Bear`
  all extend `Animal`, and each species walks its own walk
- the **strategy pattern**: what a click *does* is an interface
  (`ShootBehavior`), and swapping `Bow` for `Camera` mid-game changes
  the meaning of every shot — no if-statements anywhere

Prefer the bloodless game? You'll build it either way: the `Camera` is
the more interesting strategy, and photographs score double.

The same clone opens as a real Java project in **Eclipse**, **VS Code**,
or **Cursor**, on **Windows** or **macOS**, with no conversion step —
Swing ships inside the JDK, so there is **nothing to install** beyond
what Modules 1 and 2 already needed.

## What you need

- **Git**
- **JDK 21 or newer** (Temurin / Adoptium is the usual free build)
- One of:
  - Eclipse IDE for Java Developers (2023-12 or newer)
  - VS Code or Cursor, with the recommended **Extension Pack for Java**

Setup is identical to the first two modules — if those projects open on
your machine, this one will too. Clone URL:

```text
https://github.com/benlambm/java-gui-starter.git
```

Clone it from inside your IDE exactly the way you did before, or from a
terminal in your `eclipse-workspace` folder, then (Eclipse) **File →
Open Projects from File System…**.

## Run it FIRST

`src/Main.java` launches the game. Run it before you write anything.

The window opens and the field is **frozen**: five animals stand still,
clicks do nothing, the instrument corner is blank. That is the correct
starting state, not something you broke. Every TODO you finish thaws
it a little — and by the last one you're playing a working game you
built. Run it after every green test class; watching the game wake up
is the best progress bar in this course.

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

And a second package, `edu.vwcc.itp220mod3.gui` — the Swing window.
It is **provided**: read it, run it, wire one button in it, but the
model is where you code. Notice the boundary: the `model` package never
imports Swing, which is exactly why the tests can play the game without
opening a window.

## New Java in this module

Each gets a plain-English introduction at the top of one file. Read
these four comments first:

1. **the strategy pattern** → `ShootBehavior.java`
2. **lambdas & event listeners** → `GameFrame.java`
3. **how a GUI draws & the game loop** → `GamePanel.java`
4. **the Event Dispatch Thread** → `Main.java`

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

15 TODOs in the model plus one in the window. Every one sits under an
`Instructions:` comment that says exactly what it must do. Suggested
route, easiest to hardest:

| Step | Where | What you implement |
| --- | --- | --- |
| 1 | `Duck`, `Bear` | `move()` and `getPoints()` — study `Deer` first |
| 2 | `Bow` | `name()`, `soundEffect()`, `shoot()` — three tiny wins |
| 3 | `Camera` | Same three, plus the camera-shy state |
| 4 | `Hunter` | Pure delegation — the strategy pattern's engine room |
| 5 | `Game` | `update()` and `shoot()` — everything meets here |
| 6 | `GameFrame` | Wire the Camera button (no test — the proof is on screen) |

Order matters: `HunterTest` fires the default `Bow`, so Bow must work
before Hunter can pass, and `GameTest` uses both strategies through the
hunter. The route keeps you building on finished ground.

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

Reading tip, same as Module 2: a test that dies with a
`NullPointerException` instead of a tidy `expected: <x> but was: <y>`
means some method is still returning its `null` placeholder — usually
a `shoot()` you haven't finished. Follow the route in order and those
clear up on their own.

## The victory lap

All 28 green? Run `Main` and actually play:

- Shoot a deer with the **Bow** — it vanishes, +10.
- Switch to the **Camera** (the button *you* wired) — shoot the bear:
  +100, and it fades but keeps walking.
- Shoot it again: camera-shy, 0 points. The strategy remembered.

That ninety seconds of play exercises every class you wrote. If you can
narrate *why* each thing on screen happens — which method, which
object, which pattern — you own this material. That narration is
exactly what your walkthrough video should be.

## Stretch goals (optional, no tests)

- **A fourth species.** `Rabbit`? `Eagle`? Extend `Animal`, invent a
  movement, add a color case in `GamePanel.drawAnimal`, spawn one in
  `Game.spawnStartingAnimals`. If your species moves in a genuinely new
  way, show it off in your video.
- **A third instrument.** A `Tranquilizer` that scores face value and
  removes the animal *gently*? A `Binoculars` that scores 1 point and
  never marks anything? One new class + one new radio button — zero
  changes to `Hunter` or `Game`. *That* is why the strategy pattern
  exists, and saying so on camera is worth style points.

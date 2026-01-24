# Algorithms Design and Analysis — Lab Programs

This repository contains Java implementations of fundamental algorithms with proper documentation including aim, pseudocode, variables used, logic, time complexity, and space complexity.

---

## Program 1: Ball Tips Problem (BallTips.java)

### Aim
To calculate the number of times a ball will bounce until its velocity drops below a minimum threshold using recursion.

### Pseudocode
FUNCTION countBounces(velocity)
    IF velocity < threshold
        RETURN 0
    END IF

    newVelocity ← velocity × resistance
    RETURN 1 + countBounces(newVelocity)
END FUNCTION

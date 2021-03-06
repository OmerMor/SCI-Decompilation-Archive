;;; Sierra Script 1.0 - (do not remove this comment)
; * SCI Menu Header
;
; * Put all the defines specific to your game's menu bar in here

;NOTE: SSCI allowed defining multiple "starting" numbers in a single enum, but SCICompanion only allows one,
; so we have to start multiple enums to define the entirety of the menu system.
(enum
$100 sierraM
   aboutI
   helpI
   vaporCalcI
)

(enum
$200 fileM
   pauseI
   restartI
   quitI
)

(enum
$300 speedM
   speedI
      divider401I
   fasterI
   normalI
   slowerI
)

(enum
$400 soundM
   volumeI
   soundI
)

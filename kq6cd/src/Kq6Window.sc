;;; Sierra Script 1.0 - (do not remove this comment)
(script# KQ6WINDOW)
(include game.sh)
(use Window)


(class Kq6Window of SysWindow
	(properties
		color 16
		back 19
		eraseOnly 0
		colorOne 32
		colorFive 18
		tlColorTwo 17
		tlColorThree 18
		tlColorFour 17
		brColorTwo 18
		brColorThree 17
		brColorFour 16
	)
	
	(method (open &tmp wMap savePort)
		(= wMap VMAP)
		(if (!= priority -1) (= wMap (| wMap $0002)))
		(= lsTop (- top 5))
		(= lsLeft (- left 5))
		(= lsRight (+ right 6))
		(= lsBottom (+ bottom 6))
		(= type 128)
		(= priority 15)
		(super open:)
		(= savePort (GetPort))
		(SetPort 0)
		(self drawEdgedWindow: wMap)
		(DrawCel 930 0 0 (- left 5) (- top 5) -1)
		(DrawCel 930 0 1 (- left 5) (- bottom 1) -1)
		(DrawCel 930 0 2 (- right 1) (- top 5) -1)
		(DrawCel 930 0 3 (- right 1) (- bottom 1) -1)
		(Graph GShowBits lsTop lsLeft lsBottom lsRight 1)
		(SetPort savePort)
	)
	
	(method (drawEdgedWindow theMaps &tmp [temp0 2] i theColor)
		(Graph GFillRect top left (+ bottom 1) (+ right 1) theMaps back priority)
		(= i 1)
		(while (< i 6)
			(= theColor
				(switch i
					(1 colorOne)
					(2 tlColorTwo)
					(3 tlColorThree)
					(4 tlColorFour)
					(5 colorFive)
				)
			)
			(Graph GDrawLine
				(- top i)
				(- left i)
				(- top i)
				(+ right i)
				theColor
				priority
				-1
			)
			(Graph
				GDrawLine
				(- top i)
				(- left i)
				(+ bottom i)
				(- left i)
				theColor
				priority
				-1
			)
			(++ i)
		)
		(= i 1)
		(while (< i 6)
			(= theColor
				(switch i
					(1 colorOne)
					(2 brColorTwo)
					(3 brColorThree)
					(4 brColorFour)
					(5 colorFive)
				)
			)
			(Graph
				GDrawLine
				(+ bottom i)
				(- left i)
				(+ bottom i)
				(+ right i)
				theColor
				priority
				-1
			)
			(Graph
				GDrawLine
				(- top i)
				(+ right i)
				(+ bottom i)
				(+ right i)
				theColor
				priority
				-1
			)
			(++ i)
		)
	)
)
